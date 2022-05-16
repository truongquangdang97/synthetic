package com.example.synthetic.entity.Enum;

public enum StreetStatus {

    ACTIVE(1), UNDER(0), DOING(-1), UNDEFINED(-2);

    private int value;

    StreetStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StreetStatus of(int value) {
        for (StreetStatus status :
                StreetStatus.values()) {
            if(status.getValue() == value){
                return status;
            }
        }
        return StreetStatus.UNDEFINED;
    }
}
