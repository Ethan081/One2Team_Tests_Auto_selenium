Feature: Board
  @board
  Scenario: Create new Card
    Given user is connected to LogIn
    And user click on Board Button
    When user create new card
    Then card should be create

#  @board
  Scenario: Card drop column
    Given user is connected to LogIn and card created
    When user drop card to october column
    Then card should be prodded to new column

