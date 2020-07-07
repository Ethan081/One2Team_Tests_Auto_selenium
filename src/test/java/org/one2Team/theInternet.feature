Feature: Dropdown

  @dropdown
  Scenario Template: dropdown
    Given I was in page "https://the-internet.herokuapp.com/dropdown"
    When I select "<option>"
    Then The <option> should be "<selected>"
    Examples:
      | option | selected |
      | 1      | true     |
      | 2      | true     |
