[Nike](https://www.nike.com)
# Functional Test Cases 
## Test case №1
Name: **Adding item to the bag.**  
Preconditions: 
- Internet connection 
- opened https://www.nike.com 
- chosen location: Canada 
- logged in 

Steps:
  1. Go to the item: https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 .
  2. Select the first available size.
  3. Press button "Add to bag".
  4. Go to the bag: https://www.nike.com/cart .

Expected result: Chosen item is in the bag ("Nike Blazer Mid '77 Vintage", the size is the one you've chosen, quantity: 1, price: $105.00).

## Test case №2
Name: **Deleting item from the bag.**      
Preconditions: 
- Internet connection 
- opened https://www.nike.com 
- chosen location: Canada 
- logged in 
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag 

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Click on the trashcan icon.
  
Expected result: The message "There are no items in your bag." appeared on the page of the bag.

## Test case №3
Name: **Adding item to the favourites.**   
Preconditions: 
- Internet connection 
- opened https://www.nike.com 
- chosen location: Canada 
- logged in

Steps:
  1. Go to the item: https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 .
  2. Press button "Favourite".
  3. Go to the favourites: https://www.nike.com/favorites .

Expected result: Chosen item is in favourites ("Nike Blazer Mid '77 Vintage", price: $105.00).

## Test case №4
Name: **Deleting item from the favourites.**   
Preconditions: 
- Internet connection 
- opened https://www.nike.com 
- chosen location: Canada 
- logged in
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the favourites 

Steps:
  1. Go to the favourites: https://www.nike.com/favorites .
  2. Press button "Edit".
  3. Click on the heart icon.
  4. Press button "Done".

Expected result: The message "Items added to your Favorites will be saved here." appeared on the page of the favourites.

## Test case №5
Name: **Calculating total sum in the bag.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 
- item https://www.nike.com/t/air-force-1-07-mens-shoes-5QFp5Z/CW2288-111 is in the bag (quantity: 1)
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag (quantity: 1)   

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Check the "Total" number.
  
Expected result: "Total" is equal to the sum of items' prices in the bag ($215.00).

## Test case №6
Name: **Paying with PayPal.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag   

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Press button "PayPal".
  
Expected result: The page "Log in to your PayPal account" is shown (https://www.paypal.com/cgibin/webscr?cmd=_express-checkout&token=EC-2GE2056563373721E).

## Test case №7
Name: **Bad promo code using.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag   

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Click on the down arrow near "Do you have a Promo Code?" option.
  3. Enter "abcde" in the field that appears below.
  4. Press "Apply".

Expected result: The error message "Error. Sorry, the code entered is incorrect or invalid. Please try again, or enter another code.[ Code: 4CB0532B ]" is shown in the dialog box.

## Test case №8
Name: **Changing quantity of item.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag (quantity: 1)

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Click on the down arrow near "Quantity" option.
  3. Select option "2". 

Expected result: The item is in the bag ("Nike Blazer Mid '77 Vintage", the size is the same as in the precondition, quantity: 2, price: $210.00).

## Test case №9
Name: **Changing size of item.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 
- item https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 is in the bag (quantity: 1, size: M 7 / W 8.5)

Steps:
  1. Go to the bag: https://www.nike.com/cart .
  2. Click on the down arrow near "Size" option.
  3. Select option "M 12 / W 13.5".

Expected result: The item is in the bag ("Nike Blazer Mid '77 Vintage", size: M 12 / W 13.5, quantity: 1, price: $105.00).

## Test case №10
Name: **Adding item to the bag without selected size.**      
Preconditions: 
- Internet connection
- opened https://www.nike.com
- chosen location: Canada
- logged in 

Steps:
  1. Go to the item: https://www.nike.com/t/blazer-mid-77-vintage-mens-shoes-nw30B2/BQ6806-100 .
  3. Press button "Add to bag".

Expected result: On the page of the item error message is shown ("Please select a size."), the item is not added to the bag.






