package rocket.commands;

import rocket.stages.StageContext;
import rocket.stages.LaunchStage;
import rocket.stages.PreLaunchStage;
import rocket.stages.SecondStage;
import rocket.utils.Logger;
import rocket.utils.QualityCheck;

import java.util.Scanner;

public class CommandProcessor {

    // Initialize the StageContext with the initial PreLaunchStage
    private StageContext stageContext = new StageContext(new PreLaunchStage());

    // Create a Scanner to read user input
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        // Flag to control the loop for exiting the simulation
        boolean exitRequested = false;

        // Main loop for processing commands
        while (!exitRequested) {
            try {
                // Prompt user to enter a command
                Logger.log("Enter command:");        
                String input = scanner.nextLine();

                // Create a Command object from the user input
                Command command = new Command(input);

                // Process the action specified in the command
                switch (command.getAction()) {

                    case "start_checks":
                        // Perform pre-launch checks
                        if (QualityCheck.performChecks()) {

                            // If the current stage is PreLaunchStage, configure it
                            if (stageContext.getStage() instanceof PreLaunchStage) {
                                ((PreLaunchStage) stageContext.getStage()).configure();
                                Logger.log("Pre-Launch Checks: All systems are 'Go' for launch.");
                                
                                // Print additional checks
                                Logger.log(QualityCheck.checkFuelQuality());
                                Logger.log(QualityCheck.checkRocketStatus());
                            }
                        } else {
                            // Log if pre-launch checks fail
                            Logger.log("Pre-Launch checks failed.");
                        }
                        break;

                    case "launch":
                        // Check if pre-launch checks are completed before launching
                        if (stageContext.getStage() instanceof PreLaunchStage && !((PreLaunchStage) stageContext.getStage()).isCompleted()) {
                            Logger.log("Pre-Launch checks not completed. Cannot launch.");
                            break;
                        }

                        // Transition to LaunchStage and simulate for 10 seconds
                        stageContext.setStage(new LaunchStage());
                        if (!simulate(10)) exitRequested = true; // End the simulation if needed
                        break;

                    case "fast_forward":

                        // Fast forward the simulation by the number of seconds specified in the command's value
                        if (!simulate(command.getValue())) exitRequested = true;
                        break;

                    case "exit":

                        // Exit the loop
                        exitRequested = true;
                        break;

                    default:

                        // Log if an unknown command is entered
                        Logger.log("Unknown command");
                        
                }

                // Handle stage transitions based on completion
                if (stageContext.isStageCompleted()) {

                    // Transition from LaunchStage to SecondStage
                    if (stageContext.getStage() instanceof LaunchStage) {

                        Logger.log("Stage 1 complete. Transitioning to Stage 2.");
                        stageContext.setStage(new SecondStage());

                    } 
                    // Check if the SecondStage is completed and mission is successful
                    else if (stageContext.getStage() instanceof SecondStage) {

                        if (stageContext.getStatus().contains("Stage 2 complete")) {
                            Logger.log("Orbit achieved! Mission Successful.");
                            exitRequested = true;
                        }

                    }
                }
            } catch (Exception e) {

                // Log any errors that occur during command processing
                Logger.log("Error: " + e.getMessage());

            }
        }

        // Log the exit message and close the scanner
        Logger.log("Exiting Rocket Launch Simulator. Goodbye!");
        scanner.close();
    }

    // Simulate the rocket launch for a given number of seconds
    private boolean simulate(int seconds) {
        for (int i = 0; i < seconds; i++) {

            // Update the stage context with the current time
            stageContext.update(i);

            // Log the current status, fuel level, altitude, and kilometers traveled
            Logger.log(stageContext.getStatus());
            Logger.log("Fuel Level: " + stageContext.getFuelLevel() + " || " + "Altitude: " + stageContext.getAltitude() + "km" + " || " + "Kilometers: " + stageContext.getKilometers());
            
            // Check if the fuel level is empty
            if (stageContext.getFuelLevel() <= 0) {

                Logger.log("Fuel is empty. Mission terminated.");
                return false; // Terminate simulation

            }
            
            // Check if the mission is successful
            if (stageContext.isStageCompleted() && stageContext.getStatus().contains("Stage 2 complete")) {

                Logger.log("Orbit achieved! Mission Successful.");
                return false; // Terminate simulation upon success

            }
        }
        
        return true; // Continue simulation
    }
}
