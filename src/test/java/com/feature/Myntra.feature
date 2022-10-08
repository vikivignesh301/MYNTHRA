Feature: E-Commerce Application

Scenario: taking The Count Of Product
Given user Launch The Url
When user Mouseover To Kids Section
And select For T-Shirt
Then getting The Count Of The Product

Scenario: getting The Min Price Of The Product
When taking X-path For Discounted Price With Reference Of product Base
And add All Price To The List
Then getting Min Price

Scenario: getting Product Name For Min Price
When user Pass The Min Price On X-path 
Then validate The Brand name

Scenario: getiing Sub-brand Name Of Product Name

Then getting The Sub-brand Name