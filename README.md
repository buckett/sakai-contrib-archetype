Sakai Client Side Template Project Maven Archetype
==================================================
This project is the source to a Maven archetype for generating a Sakai 2.x project
that uses client side templates to render JSON data from the server.

Commands
--------
Generate a project using this archetype and pass all parameters:

    mvn archetype:generate \
		-DarchetypeGroupId=org.sakaiproject \
		-DarchetypeArtifactId=cst-archetype \
		-DarchetypeVersion=1.0-SNAPSHOT \
		-DgroupId=cool.application \
		-DartifactId=rad-project \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=cool.application.rad-project

Generate a project using this archetype and pass the minimum parameters:

    mvn archetype:generate \
		-DarchetypeGroupId=org.sakaiproject \
		-DarchetypeArtifactId=cst-archetype \
		-DarchetypeVersion=1.0-SNAPSHOT
