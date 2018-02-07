# PA-CRUD-RH
Crud REST API for PA Assessment 

This is a POC to provide a REST API to allow consumers to manage horse racing data.  User can enter horse, jockey and course information and also set up race meetings which can contain a list of races which in turn contain a list of race entries. 

The project has been implemented as a spring boot app and can be run from the root of the project by running:

java -jar pa-rest-service-0.1.0.jar

the app runs on port 8080

Database
--------

The data is stored in a in memory H2 database.  The database is initialised with some data that can be found in src/main/resources/data.sql

You can browse the database using the H2 console.  This has been left turned on but would be turned off in production.  To view the database browse to

http://localhost:8080/h2-console

change the JDBC URL to
jdbc:h2:mem:testdb

click connect.

Testing the app
---------------

There is a postman collection available in the root of the project PA.postman_collection.json

This can be imported into Postman and provides a collection of end-to-end tests for the REST endpoints.

Things to do
------------

I have implemented uni test for the CourseController and MeetingController.  Given time I would have done the same for the other controllers but the pattern is the same as for CourseController so I hope this provides enough.
