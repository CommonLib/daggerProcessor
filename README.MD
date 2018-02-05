# This is to extend dagger-android annotation for object inject

1. in android project build.gradle
        mavenLocal()
2. clone this project
        mvn install
        mvn install:install-file -Dfile=target/daggerObject-jar-with-dependencies.jar -DgroupId=dagger.object.inject -DartifactId=dagger-object -Dversion=1.0 -Dpackaging=jar
3. in android app build.gradle
        annotationProcessor 'dagger.object.inject:dagger-object:1.0'