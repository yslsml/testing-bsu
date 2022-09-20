[Nike](https://www.nike.com)
# Functional Test Cases 
## Test case №1
Name: Adding an item to the bag.  
Preconditions: Internet connection, opened https://www.nike.com, chosen location: Canada, logged in.    
Steps:
  1. Go to the tab "Women" -> "All shoes".
  2. Choose the first (upper-left) item.
  3. Select the first available size.
  4. Press button "Add to bag".
  5. Press button "View bag" in pop-up menu.   

Expected result: Chosen item is in bag.

## Test case №2
Name: Adding an item to the favourites.  
Preconditions: Internet connection, opened https://www.nike.com, chosen location: Canada, logged in.    
Steps:
  1. Go to the tab "Women" -> "All clothing".
  2. Choose the first (upper-left) item.
  3. Press button "Favourite".
  4. Press button "View favourites" in pop-up menu.   

Expected result: Chosen item is in favourites.

## Test case №3
Name: Calculating total sum in the bag.      
Preconditions: Internet connection, opened https://www.nike.com, chosen location: Canada, logged in.    
Steps:
  1. Go to the tab "Women" -> "All shoes".
  2. Choose the first item.
  3. Select the first available size.
  4. Press button "Add to bag".
  5. Go to the previous page.
  6. Choose the second item.
  7. Select the first available size.
  8. Press button "Add to bag".
  9. Press button "View bag" in pop-up menu. 
  10. Check the "Total" number.
  
Expected result: "Total" is equal to the sum of items' prices in bag.






