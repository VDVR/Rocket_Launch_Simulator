
package rocket; // Specifies that this class is part of the rocket package

import rocket.commands.CommandProcessor; // Imports the CommandProcessor class

import rocket.utils.Logger; // Imports the Logger class

public class RocketLaunchSimulator {

    // Main method that serves as the entry point for the application
    public static void main(String[] args) {

        
        System.out.println("---------------------------------------------------------");
        
        // Logs the start of the Rocket Launch Simulator
        Logger.log("Rocket Launch Simulator started.");
        
       
        System.out.println("-------------------------------------------");
        
        // Creates an instance of CommandProcessor to handle user commands
        CommandProcessor commandProcessor = new CommandProcessor();
        
        // Calls the run method of CommandProcessor to start processing commands
        commandProcessor.run();
    }
}
