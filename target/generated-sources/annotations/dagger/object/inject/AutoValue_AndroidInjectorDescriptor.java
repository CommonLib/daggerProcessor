
package dagger.object.inject;

import com.google.common.collect.ImmutableSet;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_AndroidInjectorDescriptor extends AndroidInjectorDescriptor {

  private final ClassName injectedType;
  private final ClassName frameworkType;
  private final ImmutableSet<AnnotationSpec> scopes;
  private final ImmutableSet<ClassName> modules;
  private final ClassName enclosingModule;
  private final String methodName;

  private AutoValue_AndroidInjectorDescriptor(
      ClassName injectedType,
      ClassName frameworkType,
      ImmutableSet<AnnotationSpec> scopes,
      ImmutableSet<ClassName> modules,
      ClassName enclosingModule,
      String methodName) {
    this.injectedType = injectedType;
    this.frameworkType = frameworkType;
    this.scopes = scopes;
    this.modules = modules;
    this.enclosingModule = enclosingModule;
    this.methodName = methodName;
  }

  @Override
  ClassName injectedType() {
    return injectedType;
  }

  @Override
  ClassName frameworkType() {
    return frameworkType;
  }

  @Override
  ImmutableSet<AnnotationSpec> scopes() {
    return scopes;
  }

  @Override
  ImmutableSet<ClassName> modules() {
    return modules;
  }

  @Override
  ClassName enclosingModule() {
    return enclosingModule;
  }

  @Override
  String methodName() {
    return methodName;
  }

  @Override
  public String toString() {
    return "AndroidInjectorDescriptor{"
         + "injectedType=" + injectedType + ", "
         + "frameworkType=" + frameworkType + ", "
         + "scopes=" + scopes + ", "
         + "modules=" + modules + ", "
         + "enclosingModule=" + enclosingModule + ", "
         + "methodName=" + methodName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AndroidInjectorDescriptor) {
      AndroidInjectorDescriptor that = (AndroidInjectorDescriptor) o;
      return (this.injectedType.equals(that.injectedType()))
           && (this.frameworkType.equals(that.frameworkType()))
           && (this.scopes.equals(that.scopes()))
           && (this.modules.equals(that.modules()))
           && (this.enclosingModule.equals(that.enclosingModule()))
           && (this.methodName.equals(that.methodName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.injectedType.hashCode();
    h *= 1000003;
    h ^= this.frameworkType.hashCode();
    h *= 1000003;
    h ^= this.scopes.hashCode();
    h *= 1000003;
    h ^= this.modules.hashCode();
    h *= 1000003;
    h ^= this.enclosingModule.hashCode();
    h *= 1000003;
    h ^= this.methodName.hashCode();
    return h;
  }

  static final class Builder extends AndroidInjectorDescriptor.Builder {
    private ClassName injectedType;
    private ClassName frameworkType;
    private ImmutableSet.Builder<AnnotationSpec> scopesBuilder$;
    private ImmutableSet<AnnotationSpec> scopes;
    private ImmutableSet.Builder<ClassName> modulesBuilder$;
    private ImmutableSet<ClassName> modules;
    private ClassName enclosingModule;
    private String methodName;
    Builder() {
    }
    @Override
    AndroidInjectorDescriptor.Builder injectedType(ClassName injectedType) {
      if (injectedType == null) {
        throw new NullPointerException("Null injectedType");
      }
      this.injectedType = injectedType;
      return this;
    }
    @Override
    AndroidInjectorDescriptor.Builder frameworkType(ClassName frameworkType) {
      if (frameworkType == null) {
        throw new NullPointerException("Null frameworkType");
      }
      this.frameworkType = frameworkType;
      return this;
    }
    @Override
    ImmutableSet.Builder<AnnotationSpec> scopesBuilder() {
      if (scopesBuilder$ == null) {
        scopesBuilder$ = ImmutableSet.builder();
      }
      return scopesBuilder$;
    }
    @Override
    ImmutableSet.Builder<ClassName> modulesBuilder() {
      if (modulesBuilder$ == null) {
        modulesBuilder$ = ImmutableSet.builder();
      }
      return modulesBuilder$;
    }
    @Override
    AndroidInjectorDescriptor.Builder enclosingModule(ClassName enclosingModule) {
      if (enclosingModule == null) {
        throw new NullPointerException("Null enclosingModule");
      }
      this.enclosingModule = enclosingModule;
      return this;
    }
    @Override
    AndroidInjectorDescriptor.Builder methodName(String methodName) {
      if (methodName == null) {
        throw new NullPointerException("Null methodName");
      }
      this.methodName = methodName;
      return this;
    }
    @Override
    AndroidInjectorDescriptor build() {
      if (scopesBuilder$ != null) {
        this.scopes = scopesBuilder$.build();
      } else if (this.scopes == null) {
        this.scopes = ImmutableSet.of();
      }
      if (modulesBuilder$ != null) {
        this.modules = modulesBuilder$.build();
      } else if (this.modules == null) {
        this.modules = ImmutableSet.of();
      }
      String missing = "";
      if (this.injectedType == null) {
        missing += " injectedType";
      }
      if (this.frameworkType == null) {
        missing += " frameworkType";
      }
      if (this.enclosingModule == null) {
        missing += " enclosingModule";
      }
      if (this.methodName == null) {
        missing += " methodName";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_AndroidInjectorDescriptor(
          this.injectedType,
          this.frameworkType,
          this.scopes,
          this.modules,
          this.enclosingModule,
          this.methodName);
    }
  }

}
