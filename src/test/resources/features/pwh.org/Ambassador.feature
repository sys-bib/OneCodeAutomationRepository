@featureTag_Ambassador
Feature: Ambassador page

   @Tag_submit_ambassador
   Scenario: Submit ambassador
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      Then Check submit ambassador status
      And User logout
      And Login as approval
      And Open project with heart homepage
      And Open profile page
      And Open approval page
      And Click under review button
      And Click reject button

   @Tag_resubmit_ambassador_is_fail
   Scenario: Resubmit Ambassador is fail
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And Click join family button
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button and validate popup message
      Then Check submit ambassador status
      And Open sitefinity page
      And Open ambassador content menu
      And Open user ambassador
      When Choose reject
      And Save ambassador changes

   @Tag_current_active_ambassador_try_to_submit_ambassador
   Scenario: Current active ambassador try to submit ambassador
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      When Submit ambassadors form should be open
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And User logout
      And Login as approval
      And Open project with heart homepage
      And Go to approval page
      When Approval page should be open
      And Click under review button
      And Click approve button
      And User logout
      And Login as user
      When Open project with heart homepage
      And Open profile page
      Then Ambassador user validation
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      When Submit ambassadors form should be open
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And Open sitefinity page
      And Open ambassador content menu
      And Open user ambassador
      When Choose terminate
      And Save ambassador changes

   @Tag_approval_ambassador
   Scenario: Approval ambassador
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      When Submit ambassadors form should be open
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And User logout
      And Login as approval
      And Open project with heart homepage
      And Go to approval page
      When Approval page should be open
      And Click under review button
      And Click approve button
      And User logout
      And Login as user
      And Open project with heart homepage
      And Open profile page
      Then Ambassador user validation
      And Open sitefinity page
      And Open ambassador content menu
      And Open user ambassador
      When Choose terminate
      And Save ambassador changes

   @Tag_terminate_ambassador
   Scenario: Terminate ambassador
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      When Submit ambassadors form should be open
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And User logout
      And Login as approval
      And Open project with heart homepage
      And Go to approval page
      When Approval page should be open
      And Click under review button
      And Click approve button
      And User logout
      And Login as user
      And Open project with heart homepage
      Then Ambassador user validation
      And Open sitefinity page
      And Open ambassador content menu
      And Open user ambassador
      When Choose terminate
      And Save ambassador changes
      And Open project with heart homepage
      And Open profile page
      And Open approval page
      And Terminate ambassador validation

   @Tag_reject_ambassador
   Scenario: Reject ambassador
      Given Login as user
         Then User should be taken sitefinity dashboard page
      Given Click ambassadors menu
      When Ambassadors page should be open
      And Click join family button
      And Fill your reason to join field
      And Select your regional
      And Fill hour permonth to volunteer
      And Fill language to speak
      And Which skill to volunteer
      When Click submit button
      And User logout
      And Login as approval
      And Open project with heart homepage
      And Open profile page
      And Open approval page
      And Click under review button
      And Click reject button
      And User logout
      And Login as user
      And Open project with heart homepage
      And Open profile page
      And Open approval page
      And Reject ambassador validation