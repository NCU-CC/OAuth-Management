## OAuth-Management [![Build Status](http://140.115.3.96:8080/jenkins/buildStatus/icon?job=OAuth-Management)](http://140.115.3.96:8080/jenkins/job/OAuth-Management/)

A website for access token management and application registration

### Maven

```sh
# run embedded server
$ mvn jetty:run
```
```sh
# export war file
$ mvn install
```

### Developing

- **add** or **modify** following files into **src/main/resources**
  - database.properties
    * jdbc.driver=com.mysql.jdbc.Driver
    * jdbc.url=jdbc:mysql://{localhost}/{dbname}
    * jdbc.username={xxx}
    * jdbc.password={xxx}
    
  - openid-setting.properties (https://github.com/NCU-CC/OpenID-Consumer)
    * openid.return_to=http://{localhost}/manage/auth
	* openid.realm=http://{localhost}
