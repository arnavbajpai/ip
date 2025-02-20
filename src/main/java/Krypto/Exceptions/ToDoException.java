package Krypto.Exceptions;
public class ToDoException extends KryptoExceptions {

    public ToDoException() {
        super("");
    }
    @Override
    public String toString() {
        return "ToDo tasks don't carry time information.";
    }
}
