/*
 * Copyright (C) 2017 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.android.processor;

import com.google.auto.common.MoreTypes;
import com.google.common.collect.ImmutableMap;
import dagger.MapKey;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;

import static com.google.auto.common.MoreElements.isAnnotationPresent;
import static com.google.common.collect.Iterables.getOnlyElement;
import static java.util.stream.Collectors.toMap;
import static javax.lang.model.util.ElementFilter.methodsIn;
import static javax.lang.model.util.ElementFilter.typesIn;

final class AndroidMapKeys {

    /**
     * Returns the Android framework types available to the compiler, keyed by their associated {@code
     * dagger.android} {@link MapKey}s. This will always contain the types that are defined by the
     * framework, and only contain the support library types if they are on the classpath of the
     * current compilation.
     */
    static ImmutableMap<Class<? extends Annotation>, TypeMirror> annotationsAndFrameworkTypes(
            Elements elements) {
        return ImmutableMap.copyOf(
                Stream.of(
                        elements.getPackageElement("dagger.android"),
                        elements.getPackageElement("dagger.android.support"),
                        elements.getPackageElement("dagger.object"))
                        .filter(packageElement -> packageElement != null)
                        .flatMap(packageElement -> typesIn(packageElement.getEnclosedElements()).stream())
                        .filter(type -> isAnnotationPresent(type, MapKey.class))
                        .filter(mapKey -> mapKey.getAnnotation(MapKey.class).unwrapValue())
                        .flatMap(AndroidMapKeys::classForAnnotationElement)
                        .collect(toMap(key -> key, key -> mapKeyValue(key, elements))));
    }

    private static Stream<Class<? extends Annotation>> classForAnnotationElement(TypeElement type) {
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Annotation> clazz =
                    (Class<? extends Annotation>) Class.forName(type.getQualifiedName().toString());
            return Stream.of(clazz);
        } catch (ClassNotFoundException e) {
            return Stream.of();
        }
    }

    private static TypeMirror mapKeyValue(Class<? extends Annotation> annotation, Elements elements) {
        List<ExecutableElement> mapKeyMethods =
                methodsIn(elements.getTypeElement(annotation.getCanonicalName()).getEnclosedElements());
        TypeMirror returnType = getOnlyElement(mapKeyMethods).getReturnType();
        // TODO(ronshapiro): replace with MoreTypes.asWildcard() when auto-common 0.9 is released
        return ((WildcardType) getOnlyElement(MoreTypes.asDeclared(returnType).getTypeArguments()))
                .getExtendsBound();
    }
}
