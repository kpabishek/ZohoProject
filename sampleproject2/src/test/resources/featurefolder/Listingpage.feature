Feature: Checking the framework
@a
  Scenario: Lisiting page presentation
    Given launching zoho presentation screen
    When in presentation screen click Listview
    Then click Grid view
    Then make a copy of it