Feature: Agent locations tests.


  Scenario: Search for opened agent locations near my Zip code.
    Given I open Western Union site
    When I press Find locations button
    And on the next page I choose my zip code "08247"
    And hit Continue button
    And on the next page I hit Open now button
    Then I can get address details of the first location printed in console


#  As a UAT tester using https://www.westernunion.com/lt/en/home.html
#I want automation tool to search for open agent locations near my Zip code 08247
#So that I could get address details of the first location printed in console
