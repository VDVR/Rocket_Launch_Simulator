package rocket.stages; // Specifies that this interface is part of the rocket.stages package

public interface Stage {
    // Method to update the stage's state based on elapsed time
    void update(int time);
    
    // Method to check if the stage has been completed
    boolean isCompleted();
    
    // Method to get the amount of fuel consumed by the stage per update
    int getFuelConsumption();
    
    // Method to get the change in altitude caused by the stage per update
    int getAltitudeChange();
    
    // Method to get the distance traveled (in kilometers) by the stage per update
    int getKilometersTravelled();
    
    // Method to get the current status of the stage
    String getStatus();
}
