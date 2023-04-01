Feature: PMIScience Contact Us

  Scenario: Verify the About PMI page and Contact Us Form
    Given I am on the website 'https://www.pmiscience.com/'
		Then Capture percy with name 'Homepage'
    Then I click on button with html tag 'button' that contains text 'I AGREE TO ALL'
#		Then I click on 'I AGREE TO ALL' cookies button
		Then Capture percy with name 'Homepage_wihout_cookies'
    Then I verify the existence of the element with tag 'img' and class 'cmp-logo'
    Then I verify the existence of the element with tag 'div' and class 'cmp-carousel__content'
    Then I click on navigation button '/en/about/'
    Then I click on button with html tag 'span' that contains text 'Contact us'
		When I fill in 'yourName' with 'Cristiano'
		And I fill in 'organization' with 'CR7'
		And I fill in 'emailAddress' with 'cristiano.ronaldo@cr7.com'
		And I fill in 'yourMessage' with 'SIUUU!'
		Then The 'yourName' field should contain 'Cristiano'
		And The 'organization' field should contain 'CR7'
		And The 'emailAddress' field should contain 'cristiano.ronaldo@cr7.com'
		And The 'yourMessage' field should contain 'SIUUU!'
    Then Capture percy with name 'Contact Us Form'