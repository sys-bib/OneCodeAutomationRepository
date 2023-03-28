Feature: PMIScience Sanity Test

  Scenario: Open Homepage
    Given I am on the website 'https://www.pmiscience.com/'
    Then Capture percy with name 'Homepage pmiscience'
