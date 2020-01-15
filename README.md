# release-genting-ccy-assessment

Project Name: exchange currency converter API
********************************************

This is the API built  to perform the currency convertion and expose the result via REST API
At the moment this program supports USD and SGD currencies which were stored in memory database.

-------------------
Pre-requistes/Technologies Used
------------------
Java version: 1.8
Maven
Spring Boot
Jersey to build JAX-RS REST API
Spring Boot TEST for junit
H2 in momory database

===============================
Setup and compiling the program
===============================
1.Download or clone the prject
2.Enter maven command 'mvn compile'  which will compile the source code of the application and generates the class file
5. once the compile is done , enter maven command "mvn clean package" which will  create the executable jar file of this project.
Once build is successful ,you can see the generated jar file under '/currencyconverterapplication/target/' folder.


================================
Running the program
================================
1. In the same command terminal enter the below command to run the program.
$ java -cp target/currencyconverterapplication-0.0.1-SNAPSHOT.jar \com.genting.ram.starter.CurrencyConversionBootStarter

If the above command doesn't identify the main class , use the below command.
$ java -cp target/currencyconverterapplication-0.0.1-SNAPSHOT.jar com.genting.ram.starter.CurrencyConversionBootStarter


================================
Accessing the API
================================
API can be acccessed using the below url.
http://localhost:8080/currency/convertion/from/usd/to/sgd/10

