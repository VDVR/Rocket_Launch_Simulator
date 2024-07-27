package rocket.stages; // Specifies that this class is part of the rocket.stages package

public class LaunchStage implements Stage {

    private boolean completed; // Tracks whether the launch stage is completed


    // Updates the state of the launch stage based on the elapsed time
    @Override
    public void update(int time) {

        // Implementation of stage logic
        if (time >= 10) { // Example condition for completing the stage
            completed = true; // Marks the stage as completed when time is 10 seconds or more
        }

    }

    // Returns whether the launch stage has been completed
    @Override
    public boolean isCompleted() {

        return completed;

    }

    // Returns the amount of fuel consumed by the launch stage per time unit
    @Override
    public int getFuelConsumption() {

        return 1; // Example fuel consumption rate

    }

    // Returns the change in altitude caused by the launch stage per time unit
    @Override
    public int getAltitudeChange() {

        return 5; // Example altitude change per second

    }

    // Returns the distance traveled (in kilometers) by the launch stage per time unit
    @Override
    public int getKilometersTravelled() {

        return 1; // Example kilometers traveled per second

    }

    // Returns the current status of the launch stage
    @Override
    public String getStatus() {

        // Returns the status based on whether the stage is completed
        return completed ? "Stage 1 complete" : "Stage 1 in progress";
        
    }
}
