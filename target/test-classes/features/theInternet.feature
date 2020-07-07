Feature: Dropdown and Checkboxes

  @dropdown
  Scenario Template: dropdown Option + "<option>"
    Given I was in page "https://the-internet.herokuapp.com/dropdown"
    When I select "<option>"
    Then The <option> should be "<selected>"
    Examples:
      | option | selected |
      | 1      | true     |
      | 2      | true     |


    @checkboxes
    Scenario Template: checkboxes <checkbox>
      Given I was in page "https://the-internet.herokuapp.com/checkboxes"
      When I select <checkbox>
      Then The <checkbox> checked should be selected
      Examples:
        | checkbox |
        | 1        |
        | 3        |

