@stores
  Feature: All Stores
    Scenario: Filter Stores By Letter

      Given navigate to Stores Page
      When click On "Tüm Mağazalar" button
      And filter the stores starting with the letter "S"
      And click on a random store
      Then the page of the selected store should be displayed