# Shopping Cart ProductQueue

Read product selected by the customer from the JMS Queue and save it into database.

This project consists of the following components :
* Apache ActiveMQ
* Spring Boot Application
* in-memory database (H2)

## Prerequisites
* jdk version : jdk1.8.0_201

## Instructions to run the project
The following script file does the following
* Launch ActiveMQ
* Compile and build application with test cases
* Run the built application

```
./launch.sh
```

## Instructions to process request
1. In the browser open the following page to view queue <http://localhost:8161/admin/queues.jsp>
2. Select _Send To_ option present in the _ProductQueue_
3. In the _Message body_ for the _ProductQueue_, Enter the following format jsonmessage to send the request to the application and send
```
{
  "id": 1,
  "productName": "Sanu",
  "quantity": 5
}
```
4. To view the updated data in the table, open the following page in the browser and connect to H2 console
http://localhost:8080/h2-console/
```
User Name: sa
Password:
JDBC URL: jdbc:h2:mem:shoppingCart
```
5. Select _PRODUCT_ and run query to view the contents of the table.
