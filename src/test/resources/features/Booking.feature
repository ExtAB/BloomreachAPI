@debug
Feature: Booking

#  Scenario: Create booking
#    Given I have permissions to access the booking system
#    When I create a booking
#      | firstName | lastName  | totalPrice | depositPaid | checkIn    | checkOut   | aditionalNeeds |
#      | John      | Macintosh | 1000       | true        | 2022-01-01 | 2022-01-01 | Breakfest      |
#      | Dee       | Jay       | 2000       | true        | 2022-02-01 | 2022-02-02 | Lunch          |
#      | Bloomy    | Reachson  | 3000       | true        | 2022-03-01 | 2022-03-03 | Dinner         |
#
#    And I want to update the user "Dee" "Jay"
#      | firstName | lastName  |
#      | Dee       | Jayson    |
#    And I want to update an user "Bloomy" "Reachson"
#      | totalPrice | checkIn    | checkOut   |
#      | 4000       | 2022-03-01 | 2022-03-10 |
#    Then I want to delete booking "John" "Macintosh"


    Scenario: Resolve mistake done by the user
      Given user creates a booking with full name: "Dee" "Jay" that paid "2000" euro, deposit paid  "true" that will check in from "2022-01-01" and check out at "2022-01-01" with specific needs of "Lunch"
      When a mistaken is identified that name of the client should have been Dee "Jayson" and properly edited
      Then the system should display the change

    Scenario: Extend users stay
      Given user creates a booking with full name: "Bloomy" "Reachson" that paid "3000" euro, deposit paid  "true" that will check in from "2022-03-01" and check out at "2022-03-03" with specific needs of "Dinner"
      When the user requests to extend his stay until "2022-03-10"
      Then the system should update the checkout date

    Scenario: Remove user from booking
      Given user creates a booking with full name: "John" "Macintosh" that paid "3000" euro, deposit paid  "true" that will check in from "2022-02-01" and check out at "2022-02-02" with specific needs of "Breakfest"
      When user wishes to cancel the booking
      Then the booking should not be displayed