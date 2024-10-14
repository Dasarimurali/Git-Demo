Feature: Add Iteams to Cart from Green Cart


@!Regression
Scenario Outline: Add Item to cart with 3 Quanities

Given I am in Landing page 
When I Search the product <ProductName> from Home Page Product appreas
Then Increase the Quanitiy by <Quanitity> on the product and click on Add to Cart
Then Click on Cart Icon 
And Validate the Product Name is displayed in cart page
And Verify user has Ability to enter Promocode <PromoCode> and Place Order

Examples:
|ProductName|Quanitity| PromoCode|
|BRO | 5 | rahulshettyacademy |

