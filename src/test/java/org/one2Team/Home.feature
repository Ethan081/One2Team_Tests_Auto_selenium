Feature: Home
  @home
  Scenario: disconnect
    Given user is connected to LogIn
    When user select dropdown profile
    And user clicks on Disconnect button
    Then user is redirected to One2Team LogIn page

  @home
  Scenario: one2Team webSite
    Given user is connected to LogIn
    When user clicks on WebSite button
    Then user is redirected to One2Team WebSite

#  Scenario: Work video
#    Given user is connected to "https://chewie.one2team.com/"
#    When user clicks on Work management button
#    Then user is redirected to Youtube One2Team channel
#    And video play