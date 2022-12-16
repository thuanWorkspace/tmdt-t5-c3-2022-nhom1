package com.example.tmdtnhom1.model;

public enum UserType {
    STORAGE("Storage"),
    VIP("VIP"),
    NORMAL("");

    private final String name;

    private UserType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
