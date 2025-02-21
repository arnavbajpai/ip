package Krypto.Exceptions;
public class IncompleteCommand extends KryptoExceptions {
    private final String type;
    public IncompleteCommand(String type) {
        super("");
        this.type = type;
    }
    @Override
    public String toString() {
        return "Too many or too less arguments for this instruction:  " + this.type;
    }
}
