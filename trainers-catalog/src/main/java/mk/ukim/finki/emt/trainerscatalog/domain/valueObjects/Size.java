package mk.ukim.finki.emt.trainerscatalog.domain.valueObjects;

public enum Size {
    US_5(5),
    US_6(6),
    US_7(7),
    US_8(8),
    US_9(9),
    US_10(10),
    US_11(11),
    US_12(12),
    US_13(13),
    US_14(14);

    private final int size;

    Size(int size) {
        this.size = size;
    }
}
