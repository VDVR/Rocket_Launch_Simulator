package rocket.commands;

public class CommandFactory {
    // Factory method to create a Command object from a given input string
    public static Command createCommand(String input) {

        // Create and return a new Command object with the specified input string
        return new Command(input);
        
    }
}
