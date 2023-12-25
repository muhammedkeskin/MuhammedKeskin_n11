@search
  Feature: Searching Keyword
    Scenario: Searching with wrong keyword

      Given navigate to Home Page
      When search with keyword "iPhone" on Home Page
      And the results should be returned accordingly
      When add the first and the last products from the first page of results to the basket
      Then added products should be in the basket