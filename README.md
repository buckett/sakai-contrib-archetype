Maven Archetype for Sakai Client Side Template Project
======================================================
This project is the source to a Maven archetype for generating a Sakai 2.x project
that uses client side templates to render JSON data from the server.

The server does not render HTML as traditional web frameworks do.  Using JAX-RS
([Apache Wink][1]), the server generates JSON for the client to use in conjunction
with an HTML template.

Calls to the server are done using AJAX via [jQuery][2] and processing of templates
are performed by [jQuery Tmpl][3].

Usage
-----
*Note: -Darchetype\* items cannot be changed.*

Generate a project using this archetype and pass all parameters:

    mvn archetype:generate \
        -DarchetypeGroupId=org.sakaiproject \
        -DarchetypeArtifactId=cst-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT \
        -DgroupId=cool.application \
        -DartifactId=radproject \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=cool.application.radproject

Generate a project using this archetype and pass the minimum parameters:

    mvn archetype:generate \
        -DarchetypeGroupId=org.sakaiproject \
        -DarchetypeArtifactId=cst-archetype \
        -DarchetypeVersion=1.0-SNAPSHOT

[1]: http://incubator.apache.org/wink/ "Apache Wink"
[2]: http://jquery.com "jQuery"
[3]: http://api.jquery.com/category/plugins/templates/ "jQuery Tmpl"
