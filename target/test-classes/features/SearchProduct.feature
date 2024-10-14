Feature: Search Produts from GreenKart


@Regression
Scenario Outline: Search from Home page and Offers Page

Given I am in Landing page 
When I Search the product <NAME> from Home Page Product appreas
Then Same product ShortText <NAME> should be displayed in Offers Page also
And Validate prodct matches with landing Page 

Examples:
|NAME |
|BRO |	
|MAN |
