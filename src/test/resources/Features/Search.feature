Feature: Search Functionality

  Scenario: Search conditions are set correctly
    Given the user is on the Mercari top page "https://jp.mercari.com/"
    When the user clicks on the search bar
    And the user clicks on "カテゴリーからさがす"
    And the user clicks on "本・雑誌・漫画"
    And the user clicks on "本"
    And the user clicks on "コンピュータ・IT"
    Then the search conditions on the left sidebar are set to "本・雑誌・漫画", "本", and "コンピュータ・IT"

  Scenario: Search conditions are set correctly from the latest browsing history.
    Given the user is on the Mercari top page "https://jp.mercari.com/"
    When the user clicks on the search bar
    And the user clicks on "カテゴリーからさがす"
    And the user clicks on "ファッション"
    And the user clicks on "すべて"
    Then the user is on the search results page

    When the user navigates to the homepage
    And the user clicks on the search bar
    And the user clicks on "カテゴリーからさがす"
    And the user clicks on "本・雑誌・漫画"
    And the user clicks on "本"
    And the user clicks on "コンピュータ・IT"
    Then the search conditions on the left sidebar are set to "本・雑誌・漫画", "本", and "コンピュータ・IT"

    When the user navigates to the homepage
    And the user clicks on the search bar
    Then there are 2 browsing history items
    And the latest browsing history item shows "コンピュータ・IT"
    When the user clicks on "コンピュータ・IT"
    Then the search conditions on the left sidebar are set to "本・雑誌・漫画", "本", and "コンピュータ・IT"

    When the user searches for "javascript"
    Then the user is on the search results page

    When the user navigates to the homepage
    And the user clicks on the search bar
    Then the latest browsing history item shows "javascript, コンピュータ・IT"