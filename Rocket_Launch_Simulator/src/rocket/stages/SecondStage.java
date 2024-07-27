package rocket.stages; // Specifies that this class is part of the rocket.stages package


public class SecondStage implements Stage {


    private boolean completed; // Tracks whether the stage is completed


    // Updates the state of the stage based on the elapsed time
    @Override
    public void update(int time) {

        // Example logic for completing the stage

        if (time >= 15) { // Condition for marking the stage as completed

            completed = true;
        }

    }

    // Returns whether the stage has been completed
    @Override
    public boolean isCompleted() {

        return completed;
    }


    // Returns the amount of fuel consumed by the stage per time unit
    @Override
    public int getFuelConsumption() {

        return 2; // Example value for fuel consumption
    }


    // Returns the change in altitude caused by the stage per time unit
    @Override
    public int getAltitudeChange() {

        return 10; // Example value for altitude change per second
    }


    // Returns the distance traveled (in kilometers) by the stage per time unit
    @Override
    public int getKilometersTravelled() {

        return 2; // Example value for distance traveled per second
    }


    // Returns the current status of the stage
    @Override
    public String getStatus() {

        // Returns the status based on whether the stage is completed
        return completed ? "Stage 2 complete" : "Stage 2 in progress";

    }
}
