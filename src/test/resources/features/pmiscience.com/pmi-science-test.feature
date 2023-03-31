Feature: Verify the About PMI page and Contact Us Form

  Scenario: Verify the About PMI page and Contact Us Form
    Given I am on the website "https://www.pmiscience.com/"
	Then Capture percy with name "Homepage"
	Then I click on ""I AGREE TO ALL" cookies button
	Then Capture percy with name "Homepage_wihout_cookies"
    Then I verify the existence of the logo
    Then I verify the existence of the banner
    Then I click on navigation button "ABOUT PMI"
    Then I click on "CONTACT US" button in section "Get in Touch"
	When I fill in "Your name" with "Cristiano"
	And I fill in "Organization" with "CR7"
	And I fill in "Email address" with "cristiano.ronaldo@cr7.com"
	And I fill in "Your message" with "SIUUU!"
	Then the "Your Name" field should contain "Cristiano"
	And the "Organization" field should contain "CR7"
	And the "Email Address" field should contain "cristiano.ronaldo@cr7.com"
	And the "Your Message" field should contain "SIUUU!"
    Then Capture percy with name "Contact Us Form"