Feature: Select My Delivery Location

  Scenario: Delivery location selection
    Given I am in landing page
    Then I select my city
    And I select my area
    Then I click on submit button
    And I see my area name