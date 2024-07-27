package rocket.stages; // Specifies that this class is part of the rocket.stages package

public class PreLaunchStage implements Stage {

    private boolean completed; // Tracks whether the pre-launch stage is completed


    // Updates the state of the pre-launch stage based on the elapsed time
    @Override
    public void update(int time) {

        // Currently no logic for updating the pre-launch stage
    }


    // Returns whether the pre-launch stage has been completed
    @Override
    public boolean isCompleted() {
        return completed;
    }


    // Method to configure the pre-launch stage
    public void configure() {

        // Example configuration logic
        completed = true; // Marks the stage as completed for demonstration purposes

    }


    // Returns the amount of fuel consumed by the pre-launch stage per time unit
    @Override
    public int getFuelConsumption() {

        return 0; // No fuel consumption during the pre-launch stage

    }


    // Returns the change in altitude caused by the pre-launch stage per time unit
    @Override
    public int getAltitudeChange() {
        
        return 0; // No change in altitude during the pre-launch stage
    }


    // Returns the distance traveled (in kilometers) by the pre-launch stage per time unit
    @Override
    public int getKilometersTravelled() {

        return 0; // No kilometers traveled during the pre-launch stage
    }


    // Returns the current status of the pre-launch stage
    @Override
    public String getStatus() {

        // Returns the status based on whether the stage is completed
        return completed ? "Pre-Launch Stage complete" : "Pre-Launch Stage in progress";

    }
}
