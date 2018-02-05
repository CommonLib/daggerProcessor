package dagger.object;

/**
 * Created by byang059 on 2/3/18.
 */
import dagger.android.AndroidInjector;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Target;

/**
 * Generates an {@link AndroidInjector} for the return type of this method. The injector is
 * implemented with a {@link dagger.Subcomponent} and will be a child of the {@link dagger.Module}'s
 * component.
 *
 * <p>This annotation must be applied to an abstract method in a {@link dagger.Module} that returns
 * a concrete Android framework type (e.g. {@code FooActivity}, {@code BarFragment}, {@code
 * MyService}, etc). The method should have no parameters.
 *
 * <p>For more information, see <a href="https://google.github.io/dagger/android">the docs</a>
 */
@Target(METHOD)
public @interface ContributesObjectInjector {
    /** Modules to be installed in the generated {@link dagger.Subcomponent}. */
    Class<?>[] modules() default {};
}