# binary-data-convertor
Simple CMD line tool build in Java that reads arbitrary file by bytes and writes them into a output text file as a sequence of 1 and 0 characters.

# Usage
```
tomas.zaoral@gl04978m binary-data-convertor {master} $ mvn -version
Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T12:57:37+01:00)
Maven home: /usr/local/Cellar/maven/3.3.3/libexec
Java version: 1.8.0_60, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.10.5", arch: "x86_64", family: "mac"
tomas.zaoral@gl04978m binary-data-convertor {master} $ 
```
(use Java8 and Maven3)

* build with `mvn clean package`
* run: `java -jar target/bdc.jar --help`
