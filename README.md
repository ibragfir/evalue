# Payment Tracker for eValue

### Prerequisites
1. JDK 8 and Maven 3.3.9 or later versions required

## Building the application (and running the Unit tests)
```maven
mvn clean package
```
This would generate _evalue-1.0-SNAPSHOT-jar-with-dependencies.jar_ file.

## Running the applicaiton
#### 1. Without reading from a file
```bash
java -jar evalue-1.0-SNAPSHOT-jar-with-dependencies.jar
```

#### 2. Start the app and read payments from a file at start up
```bash
java -jar evalue-1.0-SNAPSHOT-jar-with-dependencies.jar path_to_file
```
*Note:* path to file can be either relative or absolute

