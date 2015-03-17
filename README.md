## OAuth-Management[![Build Status](http://140.115.3.96:8080/jenkins/buildStatus/icon?job=OAuth-Management)](http://140.115.3.96:8080/jenkins/job/OAuth-Management/)

A website for access token management and application registration

### Maven
- mvn jetty:run  ->  run embedded server
- mvn install  -> export war file

### Resources

- production : put following files into
 **src/main/resources**
    - dataAccessDAO.properties
    ```
        jdbc.driver = com.mysql.jdbc.Driver
        jdbc.url = jdbc:mysql://localhost/dbname
        jdbc.username=xxx
        jdbc.password=xxx
    ```
    - openid-setting.properties ( https://github.com/NCU-CC/OpenID-Consumer )

