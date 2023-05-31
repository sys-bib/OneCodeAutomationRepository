Feature:Donation page
  Scenario: Donation page

  @Tag1_White_list_country_donation
  Scenario: White list country donation
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Click administration menu
    And Go to users menu
    And Open search field
    And Fill search keyword
    When Click search button
    And Click users according search keyword
    Then User page should be open
    And Click organization profile section
    Then Validate country
    And Click back to users button
    And Click pages menu
    Then pages menu should be open
    When Click donation page
    And Click edit at donation widget
    And Choose whitelist mode
    And Choose whitelist country
    Then Click save button
    And Click publish button
    Then Open project with heart homepage
    And Open donation page
    Then Donation page should be open
    And Validate white list country donation
    Given quit step

  @Tag2_Monthly_donation
  Scenario: Monthly donation
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Click administration menu
    And Go to users menu
    And Open search field
    And Fill search keyword
    When Click search button
    And Click users according search keyword
    Then User page should be open
    And Click organization profile section
    Then Validate country
    And Click back to users button
    Then Go to project with heart frontend
    And open donation page
    Then Donation page should be open
    And Click amount of donation
    And Click donate button
    Then Stripe page should be open
    And Click subscribe button
    Then Donate process should be successfully
    And Go to donation history to validate donation
    Then Donation history page should be open
    And Last transaction donation amount should be same
    Given quit step

#  @Tag3_Black_list_country_donation
#  Scenario: Black list country donation
#    Given User navigate to Project With Heart Sitefinity login page
#      And User enters a valid username
#      And User enters a valid password
#      And User click login button
#      When User should be taken to self logout page
#      Then User click to self logout button
#      And User click confirmation button
#      Then User should be taken sitefinity dashboard page
#    Given Click administration menu
#    And Go to users menu
#    And Open search field
#    And Fill search keyword
#    When Click search button
#    And Click users according search keyword
#    Then User page should be open
#    And Click organization profile section
#    Then Validate country
#    And Click back to users button
#    And Click pages menu
#    Then pages menu should be open
#    When Click donation page
#    And Click edit at donation widget
#    And Choose blacklist mode
#    And Choose blacklist country
#    Then Click save button
#    And Click publish button
#    Then Go to project with heart frontend
#    And open donation page
#    Then Donation page should be open
#    And Validate black list country donation
#    Given quit step
#
#  @Tag4_One_time_donation
#  Scenario: One time donation
#    Given User navigate to Project With Heart Sitefinity login page
#      And User enters a valid username
#      And User enters a valid password
#      And User click login button
#      When User should be taken to self logout page
#      Then User click to self logout button
#      And User click confirmation button
#      Then User should be taken sitefinity dashboard page
#    Given Go to project with heart frontend
#    And open donation page
#    Then Donation page should be open
#    And Click custom amount of donation
#    And Click donate button
#    Then Stripe page should be open
#    And Click subscribe button
#    Then Donate process should be successfully
#    And Go to donation history to validate donation
#    Then Donation history page should be open
#    And Last transaction donation amount should be same
#    Given quit step
#
#  @Tag5_Payroll_Donation
#  Scenario: Payroll donation
#    Given User navigate to Project With Heart Sitefinity login page
#      And User enters a valid username
#      And User enters a valid password
#      And User click login button
#      When User should be taken to self logout page
#      Then User click to self logout button
#      And User click confirmation button
#      Then User should be taken sitefinity dashboard page
#    Then Go to project with heart frontend
#    Given open active projects page
#    And active projects page should be open
#    And open_project
#    Then project page should be open
#    Given click payroll donation button
#    And payroll donation page should be open
#    And validate company email
#    And input amount donation
#    And input pmi employee id
#    Given term and conditions payroll donation
#    And Click submit payroll donation button
#    Then Donate process should be successfully
#    And Go to donation history to validate donation
#    Then Donation history page should be open
#    And Last transaction donation amount should be same
#    Given quit step