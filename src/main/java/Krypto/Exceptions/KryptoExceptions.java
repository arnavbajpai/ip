package Krypto.Exceptions;
/**
 * Represents a general exception in the Krypto application.
 * This class serves as the base class for all exceptions specific to Krypto.
 */
public class KryptoExceptions extends Exception {

    /**
     * Constructs a KryptoExceptions with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
    public KryptoExceptions(String message) {
        super(message);
    }
}