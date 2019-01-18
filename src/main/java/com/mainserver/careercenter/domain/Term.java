package com.mainserver.careercenter.domain;

public enum Term {
    FULL_TIME("Full time"),
    PART_TIME("Part time"),
    REMOTE("Remote");

    private final String stringValue;

    Term(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
