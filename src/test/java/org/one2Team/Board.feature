Feature: Board

<<<<<<< HEAD
#  Scenario: Create new Card
#    Given user is connected to LogIn
#    And user click on Board Button
#    When user create new card
#    Then card should be create
#
#
#  Scenario: Card drop column
#    Given user is connected to LogIn and card created
#    When user drop card to october column
#    Then card should be prodded to new column
  @board
  Scenario: create and drag&drop card
    Given user is connected to LogIn
    And user is on board page
    When user creates a new card
    And user drag&drop card
    Then card is correctly dragged and dropped


