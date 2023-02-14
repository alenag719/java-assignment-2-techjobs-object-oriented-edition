package org.launchcode.techjobs.oo;

import java.util.Objects;

public class PositionType extends JobField {
    public PositionType(String value){
        super(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass())return false;
        PositionType positionType = (PositionType) o;
        return getId() == positionType.getId();
    }

    }

