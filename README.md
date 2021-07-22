
## This is Coin Dispenser application



## To run the application
Use one of the several ways of running a Spring Boot application. Below are just three options:

1. Build using maven goal: `mvn clean package` and execute the resulting artifact as follows `java -jar coindispenser-0.0.1-SNAPSHOT.jar` or mvn spring-boot:run
2. On Unix/Linux based systems: run `mvn clean package` then run the resulting jar as any other executable `./coindispenser-0.0.1-SNAPSHOT.jar`


## To test the application

## There are two API available
1)  The one API is You parse an amount and it will return minimum combination of coins required to make change for the amount. link to API http://localhost:8081/api/v1.0/findMinimumCoins/{amount}
2)  The second APi  you parse it an amount and denominations which needs to be comma separated e.g "1,2,4,5", it will return minimum combination of coins required to make change for the amount. Example of API http://localhost:8081/api/v1.0/findMinimumCoinsUsingDenomination/{amount}/{denomination}  http://localhost:8081/api/v1.0/findMinimumCoinsUsingDenomination/4/1,2,3,5
