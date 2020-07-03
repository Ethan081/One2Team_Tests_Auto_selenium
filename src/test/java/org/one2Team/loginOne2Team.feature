Feature: One2Team LogIn
  As a User I want to test login function

  @notexecute
  Scenario: User Login
    Given user navigates to "https://chewie.one2team.com/"
    When user enters "userName" "etudiant4"
    When user enters "passWord" "Etudiant4*"
    When user enters "domainName" "telco"
    When user clicks on Connect button
    Then user is redirected to One2Team homepage

  @notexecute
  Scenario Template:<title>
    Given user navigates to "https://chewie.one2team.com/"
    When user enters "userName" "<user>"
    When user enters "passWord" "<password>"
    When user enters "domainName" "<domain>"
    When user clicks on Connect button
    Then login is "<login_status>" with "<message>"
    Examples:
      | title                                                                                     | user      | password   | domain | login_status | message                                            |
      | username vide --> Username field is empty.                                                |           | Etudiant4* | telco  | failed       | Username field is empty.                           |
      | mdp vide --> Wrong combination of username/password and domain.                           | etudiant4 |            | telco  | failed       | Wrong combination of username/password and domain. |
      | #username ou mdp ou domaine erroné --> Wrong combination of username/password and domain. | studiant4 | Etudiant3* | telco  | failed       | Wrong combination of username/password and domain. |



