iRebero Pig farm Management
==========================

A pig farm management module for iRebero system

Description
-----------
This is a pig farm management module, which cover the management of the farm

Building from Source
--------------------

Run following command in the project root folder:

mvn clean install
mvn package && java -jar target/irebero-0.0.1-SNAPSHOT.jar


Installation
------------
1. Build the module to produce the .jar file.
2. Use the your Web server Administration > find the screen to upload and install the .jar file.

If uploads are not allowed from the web (changable via a runtime property), you can drop the jar file
into the web server hosting folder. After putting the file in there 
simply run java -jar irebero-0.0.1-SNAPSHOT.jar.
