This is spring boot app to manage the employees in a file system. Cache is also used for performance reason.
By default the app will run on port 7777 but it can be configured by passing server.port from command line or directly modifying
the application.yml provided in src/main/resources

Unit & integration tests can be found in src/main/test package. Spring Rest docs are used to genreate the HTML format docs. HTML docs, with request, response and CURL, can be found in target/generated-docs folder.

Event is only generated in case an employee is deleted. Consumer only print the event message in the logs.

