Feature: PMIScience Sanity Test

  Scenario: Search Function Test
  	Given I am on the website 'https://www.pmiscience.com/'
    Then I click on button with html tag 'button' that contains text 'I AGREE TO ALL'
  	Then I click on navigation button '/en/smoke-free/'
  	Then I search the text 'science iqos'
  	Then Capture percy with name 'Search Result pmiscience'