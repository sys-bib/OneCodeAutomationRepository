Feature: Project page

#  Background: Existing user should be able to login to account with valid credential
#    Given User navigate to Project With Heart Sitefinity login page
#    And User enters a valid username
#    And User enters a valid password
#    And User click login button
#    When User should be taken to self logout page
#    Then User click to self logout button
#    And User click confirmation button
#    Then User should be taken sitefinity dashboard page

  @Tag_submit_project
  Scenario: Submit Project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project content menu
    When Project content menu should be open
    And Search project
    And Open submit project
    And Click more options project
    And Click delete project
    Then Confirm delete project
    And Close browser

  @Tag_revise_after_submit_project
  Scenario: Revise after review project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click under review button
    And Project request form should be open
    And Comment revise project
    And Click revise button on project request form
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    Then Validate project status is revise
    And Click need revise button
    And Click ok button to open revise form
    And Click submit button to submit revise project
    And User click confirmation button
    And Close browser
    And Open browser
    And Login as approval
    And Open project content menu
    When Project content menu should be open
    And Search project
    And Open the project
    And Click more options project
    And Click delete project
    Then Confirm delete project
    And Close browser



  @Tag_approval_project
    Scenario: Approval Project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click approve project button
    And Project request form should be open
    And Comment approve project
    Then Click approve button on project request form
    And Open sitefinity page
    And Open project content menu
    When Project content menu should be open
    And Search project
    And Open the project
    And Click more options project
    And Click delete project
    Then Confirm delete project
    And Close browser

  @Tag_revise_closure_project
    Scenario: Revise closure project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click approve project button
    And Project request form should be open
    And Comment approve project
    Then Click approve button on project request form
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    When My project page should be open
    And Open project to finalize
    And Fill final story
    And Fill expense detail
    And Fill reimbursement form
    And Upload image
    And Digital sign
    Then Click submit button to finalize
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click under review button
    And Revise closure project
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    Then Validate project status is revise
    And Close browser
    And Open browser
    And Login as approval
    And Open project content menu
    When Project content menu should be open
    And Search project
    And Open the project
    And Click more options project
    And Click delete project
    Then Confirm delete project
    And Close browser


  @Tag_revise_reimbursement_project
    Scenario: Revise reimbursement project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click approve project button
    And Project request form should be open
    And Comment approve project
    Then Click approve button on project request form
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    When My project page should be open
    And Open project to finalize
    And Fill final story
    And Fill expense detail
    And Fill reimbursement form
    And Upload image
    And Digital sign
    Then Click submit button to finalize
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click under review button
    And Revise closure project
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    Then Validate project status is revise
    And Click need revise button
    And Click ok button to open revise form
    And Click submit button to submit revise closure project
    And User click confirmation button
    Then Close browser

  @Tag_closure_project
    Scenario: Closure Project
    Given User navigate to Project With Heart Sitefinity login page
      And User enters a valid username
      And User enters a valid password
      And User click login button
      When User should be taken to self logout page
      Then User click to self logout button
      And User click confirmation button
      Then User should be taken sitefinity dashboard page
    Given Open submit project page
    When Submit project page should be open
    And Confirm and permission
    And Project title
    And Project motivation and description
    And Project location
    And Estimate date
    And Project category and project type
    And Number and hour volunteers
    And Beneficiaries and budget
    And Project documents upload
    And Sign
    Then Submit
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click approve project button
    And Project request form should be open
    And Comment approve project
    Then Click approve button on project request form
    And Close browser
    And Open browser
    And Login as user
    And Open project with heart homepage
    And Open profile page
    And Open my project page
    When My project page should be open
    And Open project to finalize
    And Fill final story
    And Fill expense detail
    And Fill reimbursement form
    And Upload image
    And Digital sign
    Then Click submit button to finalize
    And Close browser
    And Open browser
    And Login as approval
    And Open project with heart homepage
    And Open profile page
    And Open approval page
    When Submit approval page should be open
    And Click under review button
