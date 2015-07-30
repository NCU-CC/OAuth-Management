## OAuth-Management [![Build Status](http://140.115.3.96:8080/jenkins/buildStatus/icon?job=OAuth-Management)](http://140.115.3.96:8080/jenkins/job/OAuth-Management/)

A website for access token management and application registration

### Access Control
OAuth Management is only available for students, faculties and alumnus of NCU for now.

### Developing

- **add** or **modify** following files into **src/main/resources**
  - database.properties
    * jdbc.driver=com.mysql.jdbc.Driver
    * jdbc.url=jdbc:mysql://{localhost}/{dbname}
    * jdbc.username={xxx}
    * jdbc.password={xxx}

### Theme
https://github.com/almasaeed2010/AdminLTE