# gradle-with-kotlindsl-fatjar

the goal of the project is to find a configuration (Gradle with KotlinDSL)
 of this project that provides a fat jar (comes with all dependencies in its jar-file). In other words,
after calling `gradle clean build` there should be a jar in the build/libs folder that contains all of its
dependencies (e.g. the code for [ktor](https://ktor.io/quickstart/quickstart/gradle.html)).
 
 The problem arouse when the shadowJar plugin stopped working after the configuration was converted from
  GroovyDSL to KotlinDSL. So a solution with shadowJar would be fine, but there seems to be a possibility to
 do this purely with the jar-task (because there exists [tutorials with the GroovyDSL doing exactly this](https://www.baeldung.com/gradle-fat-jar)). The the problems and hopefully solutions are investigated
 in this [Stackoverflow thread](https://stackoverflow.com/questions/55575264/creating-a-fat-jar-in-gradle-with-kotlindsl).
 
 The original code to start from lies in the branch called "problem". Different solutions
 (e.g. based on the plugins being used) should go into different branches.