# roundup

Before starting please generate a bearer token and place in

`src/main/resources/application.properties`

To build the project run 

`mvn clean install`

To start the project run

`java -jar .\target\roundup-0.0.1-SNAPSHOT.jar`
(reverse slashes for macOS/Linux)

To start the calculation hit

`http://localhost:8080`

in a web browser/Postman/etc

The returned value is the uuid of the created Savings Goal which can then be viewed by going to

`https://api-sandbox.starlingbank.com/api/v1/savings-goals/{uuid}`

with the appropriate Auth headers set.

## To do

* Error handling
* Refactor REST calls to remove duplicate code (Template pattern)


