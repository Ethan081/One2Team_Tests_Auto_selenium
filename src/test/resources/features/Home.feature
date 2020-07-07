Feature: Home


  @home
  Scenario: disconnect
    Given user is connected to LogIn
    When user select dropdown profile
    And user clicks on Disconnect button
    Then user is redirected to One2Team LogIn page


  Scenario Template:click on button <button>
    Given user is connected to LogIn
    When user clicks on "<button>" "<css>"
    Then user is redirected to "<page>"
    Examples:
      | button       | css     | page                |
      | One2Team     | div[1]  | one2team.com        |
      | Google Drive | div[2]  | drive.google.com    |
      | Planning     | div[3]  | chewie.one2team.com |
      | Support      | div[7]  | rod.one2team.com    |
      | Calendar     | div[9]  | calendar.google.com |
      | Videos       | div[10] | youtube.com         |

