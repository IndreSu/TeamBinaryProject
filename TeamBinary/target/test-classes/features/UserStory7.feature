Feature: Ensure search functionality is working correctly

  Background:
    Given Application is launched

@TestCase1
  Scenario: Verify search is displayed on different pages
    When I navigate to Contact Us page
    Then Search is displayed on every page screen

    When I navigate to MyAccount Register
    Then Search is displayed on every page screen

    When I navigate to MyAccount Login
    Then Search is displayed on every page screen

    When I navigate to Wish List page
    Then Search is displayed on every page screen

    When I navigate to Shopping Cart page
    Then Search is displayed on every page screen

    When I navigate to Checkout page
    Then Search is displayed on every page screen

    When I navigate to Tablets category by clicking on first level menu
    Then Search is displayed on every page screen

    When I navigate to Desktops Mac sub-category by clicking on second level menu
    Then Search is displayed on every page screen

  @TestCase8
  Scenario: Verify search with text input
    When I input the text "mac" in the search field
    And I select search button
    Then I verify that result include items related to "mac"

  @TestCase9
  Scenario: Verify search with numbers input
    When I input numbers "300" in the search field
    And I select search button
    Then I verify that result include items related to numbers "300"

  @TestCase11
  Scenario: Verify search field has blue line
    When I input the text "a" in the search field with grey borders
    Then I verify that the borders of the field has bleu borders

  @TestCase23
  Scenario: Verify search in product descriptions has result
    When I select search icon when search field is empty
    And I select a checkbox: Search in product descriptions
    And I input the text "phone" in the search criteria field
    And I select blue search button
    Then I verify that result include items related to "phone"

  @TestCase24
  Scenario: Verify search in product descriptions has no result
    When I select search icon when search field is empty
    And I select a checkbox: Search in product descriptions
    And I input the text "aaaaa" in the search criteria field
    And I select blue search button
    Then I verify that correct message is displayed

  @TestCase27
  Scenario: Verify search in product subcategories has result
    When I select search icon when search field is empty
    And I input the text "tab" in the search criteria field
    And I select "Tablets" category
    And I select a checkbox: Search in subcategories
    And I select blue search button
    Then I verify that result include items related to "tab"

  @TestCase28
  Scenario: Verify search in product subcategories has no result
    When I select search icon when search field is empty
    And I input the text "aaaaa" in the search criteria field
    And I select "Tablets" category
    And I select a checkbox: Search in subcategories
    And I select blue search button
    Then I verify that correct message is displayed

  @TestCase29
  Scenario: Verify search in product subcategories and descriptions
    When I select search icon when search field is empty
    And I input the text "mac" in the search criteria field
    And I select "Laptops & Notebooks" category
    And I select a checkbox: Search in subcategories
    And I select a checkbox: Search in product descriptions
    And I select blue search button
    Then I verify that result include items related to "mac"

  @TestCase30
  Scenario: Verify that list of products after search have pagination
    When I select search icon when search field is empty
    And I select a checkbox: Search in product descriptions
    And I input the text "a" in the search criteria field
    And I select blue search button
    Then I verify that list of products have pagination