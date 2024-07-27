package rocket.commands;

public class Command {
    private String action; // Represents the action to be performed by this command

    private int value; // Represents an optional numeric value associated with the command

    // Constructor that parses the input string and initializes the action and value
    public Command(String input) {

        // Split the input string into parts based on spaces
        String[] parts = input.split(" ");

        // Set the action to the first part of the input
        this.action = parts[0];

        // Check if there is a second part (a numeric value)
        if (parts.length > 1) {
            try {

                // Attempt to parse the second part as an integer and set the value
                this.value = Integer.parseInt(parts[1]);
                
            } catch (NumberFormatException e) {
                // If parsing fails, set value to 0
                this.value = 0;
            }
        }
    }

    // Getter method for the action field
    public String getAction() {
        return action;
    }

    // Getter method for the value field
    public int getValue() {
        return value;
    }
}
