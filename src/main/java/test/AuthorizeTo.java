package test;

import java.lang.annotation.*;

/**
 * Created by DONGCHULKIM on 2016-12-22.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizeTo {
	String value();
}
