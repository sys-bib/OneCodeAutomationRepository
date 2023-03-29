Feature: PMIScience Sanity Test

  #Scenario: Open Homepage pmiscience
    #Given I am on the website 'https://www.pmiscience.com/'
    #Then Capture percy with name 'Homepage pmiscience'

  Scenario: Search Function Test
  	Given I am on the website 'https://www.pmiscience.com/'
  	Then I click on navigation button '/en/smoke-free/'
  	Then I search the text 'science iqos'
  	Then Capture percy with name 'Search Result pmiscience'