# Spring_Boot_Contract_First_API_Sample
Spring Boot and Open API generator based implementation of generated models and API. 
Demonstrates use of jackson deserializers to support oneOf schema construct of open api 3. This is motivated by the current
lack of support for this construct in the existing spring generator of openapi-generator-maven-plugin.

Important concepts used:

* Use of openapi-generator-maven-plugin to support contract first reactive API development. See pom.xml
* Use of custom jackson deserializer to support oneOf schema
