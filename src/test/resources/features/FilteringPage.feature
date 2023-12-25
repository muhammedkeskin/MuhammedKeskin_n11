@filter
  Feature: All Stores
    Scenario: Sorting and filtering products by free shipping

      Given navigate to Home Page
      When search with keyword "telefon" on Home Page
      And filter by brand number 2
      And sort incoming results by number of comments
      Then order should be correct on Results Page
      When list incoming products with free shipping
      Then all products must be seen to come with free shipping
