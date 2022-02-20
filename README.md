
<h1 align="center">Assignment</h1>

## 🚀 Installation
To run the automation project, you should run ```mvn verify``` from the command line or

```shell
mvn clean install
```

## 🔥 Executing the tests
To execute the entire set of tests write on the command promp

```shell
mvn test
```

The test results will be recorded in the `target/site/serenity` directory.

## 📁 File structure

Assignment

```
.idea/
src/
├─ main/
│  ├─ java/
│  │  ├─ controller/
│  │  ├─ EnvironmentController.java
│  │
│  │  ├─ model/
│  │  ├─ Booking.java
│  │  ├─ Bookingdates.java
│  │  
│  │  
│  │  
│  │
│  │  ├─ resources/
│  │  │  ├─ requestPayloads/
│  │  │  ├─ admin.json
│  │  │  ├─ validBookingData.json
│  │  │  
│  │  │  
│  │
│  │  ├─ restAPI/
│  │  │  ├─ Endpoints.enum
│  │  │  ├─ BookingClient.java
├─ test/
│  ├─ java/
│  │  ├─ stepdefinitions/
│  │  │  ├─ BookingStepDefinitions.java
│  │  ├─ steps/
│  │  │  ├─ BookingSteps.java
│  │  ├─ CucumberTestSuite.java
│  │
│  ├─ resources/
│  │  ├─ features/
│  │  │  ├─ Booking.feature
.gitattributes
.gitignore
pom.xml
README.md

```
## 🚚 Bugs
API

1. Get Booking By ID  is ignoring 'Accept' content type
1.1 ID of Get is string but is generating only numeric values
2. Create not filling the headers give error 500
3. Create first name and last can accept numbers.
4. Total price accepts string as numbers and returns null if sent text in total price.
5. Boolean is default true, sending a string is creating true. Additional needs accepts numeric and string type. Checking accepts future dates, checkin accepts unique characters and returns 200 status code  with invalid page
6. Update changing the name sirname to digit server error 500
7. PartialUpdateBooking Always returns method not allowed, even though done identical as the example given
8. Delete is returning 201 with response create instead of successfully deleted

[Assignment thoughts](https://www.notion.so/Assignment-thoughts-f136790b32d4435a9ffad08a5f883a2d)

[comment]: <> (Todo)
[comment]: <> (##Code Example)
[comment]: <> (##Code style)
[comment]: <> (## Build status)
[comment]: <> (##Features)
[comment]: <> (##API Reference)
[comment]: <> (##Screenshots)