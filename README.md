# quarkus-rest-sandbox

Lessons Project. Repository for code which I wrote during Starting with Quarkus study (https://www.udemy.com/course/quarkus-starting-with-quarkus/).

Simple Quarkus application which provide tree enpoints to get list of books (```/api/books```), get count of books (```/api/books/count```) and get information about book by id (```/api/books/{id}```).

Example of response from ```/api/books```:
```
[
    {
        "author": "Antonio",
        "genre": "Software Technology",
        "id": 1,
        "title": "Understanding Quarkus",
        "yearOfPublication": 2020
    },
    {
        "author": "Antonio",
        "genre": "Software Technology",
        "id": 2,
        "title": "Practising Quarkus",
        "yearOfPublication": 2020
    },
    {
        "author": "Josh Blocj",
        "genre": "Software Technology",
        "id": 3,
        "title": "Effective Java",
        "yearOfPublication": 2001
    },
    {
        "author": "Brus Eckel",
        "genre": "Software Technology",
        "id": 4,
        "title": "Thinking in Java",
        "yearOfPublication": 1998
    }
]
```
Example of response from ```/api/books/1```:
```
{
    "author": "Antonio",
    "genre": "Software Technology",
    "id": 1,
    "title": "Understanding Quarkus",
    "yearOfPublication": 2020
}
```

This project uses Quarkus, the Supersonic Subatomic Java Framework.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvn package -DskipTests -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvn package -DskipTests -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvn package -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.native.container-build=true 
-Dquarkus.container-image.tag=native
```

You can then start your native executable in created Docker container with: `docker run -i --rm -p 8080:8080 {your_container_name }:native`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

