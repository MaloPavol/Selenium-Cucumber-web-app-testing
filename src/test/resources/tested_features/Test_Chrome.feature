Feature: Submit your name
  Scenario: User fills in his name in the HTML-form and clicks submit
    Given the from is opened in chrome
    When user fills in his/her name and clicks submit
    Then confirmation page is loaded