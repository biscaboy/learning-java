package com.davidjdickinson.reflection.util;

import com.davidjdickinson.reflection.annotation.ColumnField;
import com.davidjdickinson.reflection.annotation.PrimaryKeyField;
import com.davidjdickinson.reflection.model.Column;
import com.davidjdickinson.reflection.model.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {

    private Class<T> clss;
    public static <T> MetaModel<T> of(Class<T> clss) {
        return new MetaModel<>(clss);
    }

    public MetaModel(Class<T> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            // check to see if there is the primary key annotation
            PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
            if (primaryKey != null) {
                PrimaryKeyField primaryKeyField = new PrimaryKeyField(field);
                return primaryKeyField;
            }
        }
        throw new IllegalArgumentException("No primary key found in class " + clss.getSimpleName());
    }

    public List<ColumnField> getColumns() {

        List<ColumnField> columnFields = new ArrayList<>();
        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            // check to see if there is the primary key annotation
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                ColumnField columnField = new ColumnField(field);
                columnFields.add(columnField);
            }
        }
        return columnFields;
    }
}

