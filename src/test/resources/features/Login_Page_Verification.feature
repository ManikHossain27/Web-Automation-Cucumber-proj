Feature: Login Page Verification

  Scenario Outline: Login With Valid Credential
    Given I am in landing page
    When I enter User Name <userName>
    And I enter Password <password>
    And I click on Login button
    Then I see the Inventory page

    Examples:
    |       userName          |   password   |
    |"standard_user"          |"secret_sauce"|
    |"locked_out_user"        |"secret_sauce"|
    |"problem_user"           |"secret_sauce"|
    |"performance_glitch_user"|"secret_sauce"|
    |"error_user"             |"secret_sauce"|
    |"visual_user"            |"secret_sauce"|


