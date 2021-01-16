@fullTestSuit @GUI
Feature: borrow limt based on the current income and existing financial commitments

  @Contact_NegativeValidation
  Scenario: Contact Details Negative validation
    Given I navigate to "http://jupiter.cloud.planittesting.com"
    Then I navigate to page "contact"
    Then I submit the contact details
    Then I verify the below details
      | Element       | Visibility |
      | forenameError | Present    |
      | emailError    | Present    |
      | messageError  | Present    |
    Then I enter contact details
      | Forename | Email                    | message  |
      | Sindhu   | sindhu.gunalan@gmail.com | Toy cost |
    Then I verify the below details
      | Element       | Visibility  |
      | forenameError | Not Present |
      | emailError    | Not Present |
      | messageError  | Not Present |

  @Contact_Details_Submit
  Scenario: Contact Details Negative validation
    Given I navigate to "http://jupiter.cloud.planittesting.com"
    Then I navigate to page "contact"
    Then I enter contact details
      | Forename | Email           | message  |
      | Sindhu   | adffn@gmail.com | Toy cost |
    Then I submit the contact details
    Then I verify the below details
      | Element               | Visibility |
      | contactDetailsSuccess | Present    |

  @Contact_Details_Invalid
  Scenario: Contact Details Negative validation
    Given I navigate to "http://jupiter.cloud.planittesting.com"
    Then I navigate to page "contact"
    Then I enter contact details
      | Forename | Email | message  |
      |     1233 |   122 | Toy cost |
    Then I submit the contact details
    Then I verify the below details
      | Element         | Visibility |
      | validEmailError | Present    |

  @Toy_Shopping
  Scenario: Contact Details Negative validation
    Given I navigate to "http://jupiter.cloud.planittesting.com"
    Then I navigate to page "startShopping"
    Then I add the below items to cart
      | Item           |
      | funnyCowBuy    |
      | funnyCowBuy    |
      | fluffyBunnyBuy |
    Then I validate the below items in the cart
      | Item                | Quantity |
      | funnyCowCartItem    |        2 |
      | fluffyBunnyCartItem |        1 |
