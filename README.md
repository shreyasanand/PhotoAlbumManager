#Photo Album Manager

A simple Photo Album manager providing REST APIs to manage photos and albums. 
Developed using Java and Spring boot framework.

##The Rest API supports the following functionalities:
	1) Albums
		- Create a new album - POST : /myapi/albums
		- Read/Return a list of all albums - GET : /myapi/albums
		- Update an existing album - PUT : /myapi/albums/{id}
		- Delete an existing album - DELETE : /myapi/albums/{id} (Constraint: No photos in the album)
		
	2) Photos
		- Create a new photo - POST : /myapi/photos
		- Read/Return a list of all photos - GET : /myapi/photos
		- Update an existing photo - PUT : /myapi/photo/{id}
		- Delete an existing photo - DELETE : /myapi/photos/{id}
		- Read/Return a list of photos in a given album - GET : /myapi/photos/byalbum/{id}
		
## How to install?

	- You can build the application package using 
		mvnw clean package
	- Then run the jar PhotoManagerREST-0.0.1-SNAPSHOT.jar
	
##Todo
	- Unit tests