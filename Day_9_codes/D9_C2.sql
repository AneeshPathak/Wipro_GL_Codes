/* Question 2 - The e-commerce offering online services to their clients. They are managing the product's sale and purchase through this website. 
                They wants find the products with different categories like furniture,laptop and mobile

                Instructions- Display the products fall under the category furniture,laptop, mobile (Use membership operator ‘in’ ) and prices less than 50000

    ****FILE NAME IS GIVEN DIFFERENTLY FOR SORTING OF FILES DAY WISE.***** */

-- Answer 

SELECT *
from product
WHERE category IN ("furniture", "laptop", "mobile")
AND prICE < 50000