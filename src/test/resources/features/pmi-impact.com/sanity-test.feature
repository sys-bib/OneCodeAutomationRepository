Feature: PMIImpact Sanity Test

  Scenario: Open Homepage pmi-impact
    Given I am on the website 'https://www.pmi-impact.com/'
    Then Capture percy with name 'Homepage pmi-impact.com'
