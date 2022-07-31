package tr.com.nihatalim.jpalockingmechanizm.core.enums;

public enum ProductProcessEnum {
    NOT_STARTED(0),
    SUCCESS(1),
    FAILED(2);

    private final int status;

    ProductProcessEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
