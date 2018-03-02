# This is to extend dagger-android annotation for object inject

1. in android project build.gradle
        mavenLocal()
2. clone this project
        mvn install
        mvn install:install-file -Dfile=target/daggerObjectProcessor-jar-with-dependencies.jar -DgroupId=dagger.object.inject -DartifactId=dagger-object-processor -Dversion=2.13 -Dpackaging=jar
        mvn install:install-file -Dfile=target/daggerObjectProcessor-jar-with-dependencies.jar -DgroupId=dagger.object.inject -DartifactId=dagger-object-processor -Dversion=2.13 -Dpackaging=jar -DgeneratePom=true -DlocalRepositoryPath=/Users/byang059/IdeaProjects/jar-repo -DcreateChecksum=true

3. in android app build.gradle
        annotationProcessor 'dagger.object.inject:dagger-object:1.0'