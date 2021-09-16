package Equipment.Execptions;

public class InvalidItemException extends Throwable {
    public InvalidItemException(String format) {
        super(format);
    }
}
