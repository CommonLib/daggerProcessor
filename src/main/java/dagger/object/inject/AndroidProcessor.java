package dagger.object.inject;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableList;
import com.google.googlejavaformat.java.filer.FormattingFiler;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * An {@linkplain javax.annotation.processing.Processor annotation processor} to verify usage of
 * {@code dagger.android} code.
 */
@AutoService(Processor.class)
public final class AndroidProcessor extends BasicAnnotationProcessor {
    @Override
    protected Iterable<? extends ProcessingStep> initSteps() {
        Filer filer = new FormattingFiler(processingEnv.getFiler());
        Messager messager = processingEnv.getMessager();
        Elements elements = processingEnv.getElementUtils();
        Types types = processingEnv.getTypeUtils();

        return ImmutableList.of(
                new AndroidMapKeyValidator(elements, types, messager),
                new ContributesAndroidInjectorGenerator(
                        filer, new AndroidInjectorDescriptor.Validator(types, elements, messager)));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
