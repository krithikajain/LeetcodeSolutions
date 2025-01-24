<h2>search-a-2d-matrix Notes</h2><hr>[ Time taken: 42 m 28 s ]

<p>
  The code uses two binary searches:

1. The first binary search identifies the row where the target might exist by comparing the target with the smallest and largest elements of each row.<br>
 - if the target row is found, it is stored in another variable
 - if not the value of the variable doesn't change indicating the value is not present in any of the rows, then return false 
2. The second binary search searches for the target within that row.<br>
   <p>If the target is found, the code returns true; otherwise, it returns false.</p>
</p>
