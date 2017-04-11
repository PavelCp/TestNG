package com.testng;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by November on 29.03.2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SkippedIn {

    DriverType[] value() default {DriverType.ALL};

    Platform[] platforms() default {Platform.ALL};

    String reason() default ("Skipped in browser");

    int[] issues() default {};
}
