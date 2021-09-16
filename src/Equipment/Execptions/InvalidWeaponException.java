package Equipment.Execptions;

public class InvalidWeaponException extends InvalidItemException {
    public InvalidWeaponException(String format) {
        super(format);
    }
}
