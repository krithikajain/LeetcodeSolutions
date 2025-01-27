<h2>best-time-to-buy-and-sell-stock Notes</h2><hr>[ Time taken: 7 m 9 s ]

The code keeps track of the lowest price (`minPrice`) seen so far while iterating through the array. 

For each price, it calculates the profit if the stock was bought at `minPrice` and sold at the current price. 

It updates the maximum profit (`maxProfit`) if this new profit is greater. 

At the end, it returns the highest profit found.
