@test1
Feature: Create new Lead with status change
  User creates new Lead, checks if status is set to New, changes it to some other status and finally verifies if new status was properly set

  @clearLeads
  Scenario: Create new Lead and change status
    Given User is logged in
    When User goes to Leads tab
    And User creates new Lead
      | Mark                    |
      | Johnson                 |
      | Design Services Company |
    Then Newly created Lead should have "New" status
    When User edits Lead status
    Then Status should be properly changed to "Some New Status"