package com.davidjdickinson.reflection.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {

    /*
        There are three stages when an annotation is available (in RetentionPolicy):

            1. SOURCE = Compile
            2. CLASS = Class loading
            3. RUNTIME = Runtime

        If you want to have the annotation read at runtime you have to annotate the class as such.

     */
}
