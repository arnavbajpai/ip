package Krypto.Exceptions;
public class InvalidCommand extends KryptoExceptions {
    private final String unknown;

    public InvalidCommand(String unknown) {
        super("");
        this.unknown = unknown;
    }
    @Override
    public String toString() {
        return String.format("Sorry. I don't know what `%s` means.", this.unknown);
    }
}
