package rocket.utils; // Specifies that this class is part of the rocket.utils package

import java.io.FileWriter; // Imports FileWriter for writing log messages to a file

import java.io.IOException; // Imports IOException for handling input/output exceptions

import java.time.LocalDateTime; // Imports LocalDateTime for obtaining the current date and time

import java.time.format.DateTimeFormatter; // Imports DateTimeFormatter for formatting the date and time

public class Logger {
    private static final String LOG_FILE = "rocket_launch_simulator.log"; // File name for the log file

    // Static method to log messages
    public static void log(String message) {

        // Get the current date and time, formatted as "yyyy-MM-dd HH:mm:ss"
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Create the log message with timestamp
        String logMessage = timestamp + " - " + message;

        // Print the log message to the console
        System.out.println(logMessage);

        // Append the log message to the log file
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {

            writer.write(logMessage + "\n"); // Write the log message followed by a newline

        } catch (IOException e) {

            // Print an error message to the console if an IOException occurs
            System.err.println("Error writing to log file: " + e.getMessage());
            
        }
    }
}
