package rocket.stages; // Specifies that this class is part of the rocket.stages package

public class StageContext {

    private Stage currentStage; // Holds the current stage of the rocket

    private int fuelLevel; // Tracks the current fuel level

    private int altitude; // Tracks the current altitude

    private int kilometers; // Tracks the kilometers traveled

    // Constructor to initialize the StageContext with an initial stage
    public StageContext(Stage initialStage) {

        this.currentStage = initialStage; // Set the initial stage

        this.fuelLevel = 100; // Example initial fuel level
        
        this.altitude = 0; // Initial altitude

        this.kilometers = 0; // Initial kilometers traveled
    }

    // Returns the current stage
    public Stage getStage() {
        return currentStage;
    }

    // Sets a new stage as the current stage
    public void setStage(Stage newStage) {
        this.currentStage = newStage;
    }

    // Updates the context based on the current stage and time
    public void update(int time) {

        currentStage.update(time); // Update the current stage based on time

        fuelLevel -= currentStage.getFuelConsumption(); // Decrease fuel level based on stage's fuel consumption

        altitude += currentStage.getAltitudeChange(); // Increase altitude based on stage's altitude change
        
        kilometers += currentStage.getKilometersTravelled(); // Increase kilometers based on stage's traveled distance
    }

    // Returns the current fuel level
    public int getFuelLevel() {
        return fuelLevel;
    }

    // Returns the current altitude
    public int getAltitude() {
        return altitude;
    }

    // Returns the total kilometers traveled
    public int getKilometers() {
        return kilometers;
    }

    // Checks if the current stage is completed
    public boolean isStageCompleted() {
        return currentStage.isCompleted();
    }

    // Returns the status of the current stage
    public String getStatus() {
        return currentStage.getStatus();
    }
}
