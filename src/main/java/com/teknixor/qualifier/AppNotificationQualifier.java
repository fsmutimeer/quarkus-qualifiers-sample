package com.teknixor.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import jakarta.inject.Qualifier;

@Qualifier
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ TYPE, METHOD, FIELD, PARAMETER })
public @interface AppNotificationQualifier {

}
