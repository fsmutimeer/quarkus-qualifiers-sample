package com.teknixor.qualifier;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

@Qualifier
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ TYPE, METHOD, PARAMETER, FIELD })
public @interface PushNotificationQualifier {

}
