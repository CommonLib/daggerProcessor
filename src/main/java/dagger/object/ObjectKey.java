package dagger.object;

import dagger.MapKey;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by byang059 on 2/1/18.
 */
@MapKey
@Documented
@Retention(RUNTIME)
public @interface ObjectKey {
    Class<? extends Object> value();
}
