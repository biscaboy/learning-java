package com.davidjdickinson.reflection.annotation;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private Field field;
    public PrimaryKeyField(Field primaryKey) {
        this.field = primaryKey;
    }

    public String getName() {
        return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }
}
