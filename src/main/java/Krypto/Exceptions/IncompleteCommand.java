package Krypto.Exceptions;

/**
 * Represents an exception thrown when a command has either too many or too few arguments.
 */
public class IncompleteCommand extends KryptoExceptions {

    private String type;

    /**
     * Constructs an IncompleteCommand exception with the specified command type.
     *
     * @param type The type of command that has an incomplete number of arguments.
     */
    public IncompleteCommand(String type) {
        super("");
        this.type = type;
    }

    @Override
    public String toString() {
        return "Too many or too few arguments for this instruction: " + this.type;
    }
}