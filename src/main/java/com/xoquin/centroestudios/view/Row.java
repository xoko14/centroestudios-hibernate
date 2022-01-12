package com.xoquin.centroestudios.view;

import java.lang.reflect.Field;

public class Row {
    private String name;
    private int maxLength;

    public Row(Field field) {
        this.name = field.getName();
        maxLength = this.name.length();
    }

    public String getName() {
        return this.name;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    
}
