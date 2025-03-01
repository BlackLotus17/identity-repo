Feature: Confirm the page title
  As a customer
  I want to check car registration number
  So that I can validate the value of my vehicle


  @wip
  Scenario Outline: Assert the page title
    Given I am on the home page
    When I check <carPosition> registration number
    Then I will get result for <carPosition>
    Examples:
      |carPosition|
      |0           |
      |1           |
      |2           |
      |3           |