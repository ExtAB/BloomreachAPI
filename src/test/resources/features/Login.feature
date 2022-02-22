Feature: Login

  Scenario Outline:Login with different user roles
    Given I want to access as a "<Role>"
    When I login using "<Username>" "<Password>" with language "<Language>"
    Then I should see I am logged in

    Examples:
      | Role          | Username | Password | Language |
      | Author        | author07 | author07 | English  |
      | Editor        | editor19 | editor19 | Deutsch  |
      | Administrator | admin03  | admin03  | X        |

#    Scenario: negative
#      Given I login with Author
#      When I want to give permission to user
#      Then I should not be able to


