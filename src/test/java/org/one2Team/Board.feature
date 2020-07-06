Feature: Board

  @board
  Scenario: create and drag&drop card
    Given user is connected to LogIn
    And user is on board page
    When user creates a new card
    And user drag&drop card
    Then card is correctly dragged and dropped


