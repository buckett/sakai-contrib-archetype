Maven Archetype for Sakai Contrib Project
======================================================
This project is the source to a Maven archetype for generating a Sakai 2.x project.

This is different to a standard Sakai project in that it doesn't depend on a parent POM
but builds it's dependencies in the base pom, this is partly because the purepoms
didn't exist for 2.6. This means it uses the standard maven layout is used.

Usage
-----
*Note: -Darchetype\* items cannot be changed.*

Generate a project using this archetype and pass all parameters:

    mvn archetype:generate \
        -DarchetypeGroupId=org.sakaiproject \
        -DarchetypeArtifactId=sakai-contrib-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT \
        -DgroupId=cool.application \
        -DartifactId=radproject \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=cool.application.radproject

Generate a project using this archetype and pass the minimum parameters:

    mvn archetype:generate \
        -DarchetypeGroupId=org.sakaiproject \
        -DarchetypeArtifactId=sakai-contrib-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT

