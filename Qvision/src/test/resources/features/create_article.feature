#author lion989821@hotmail.com

  Feature: Use the page
    #Me as a user i want to create account and create atricle to verify the functioning of the page

  Scenario: Create account
    Given "user" is on the web
    When "pepito" creates account
    Then shoulds see a msg on the page

  Scenario: Login on conduit
    Given "user" is on the web
    When "pepito" logs on conduit
    Then shoulds see a msg on the page

  Scenario: Create article
    Given "user" is on the web
    When "pepito" logs on conduit
    When "articleA" is created
    Then shoulds see the article on the page
