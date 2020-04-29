package v1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class BackendTestDriver {

	public static void main(String[] args) {

		/* 
		 * Calories are the AVERAGES for the specified food
		 * If a food's listing is plural (i.e. Blueberries) the listed calories are for one SERVING
		 * i.e. a cup of blueberries, a bowl of Cheerios, a cup of milk, one apple, etc.
		 */
		FoodList fl= new FoodList();
		//---Foods---

		//Breakfast
		fl.addFood("Scrambled Egg", 91);
		fl.addFood("Boiled Egg", 78);
		fl.addFood("Fried Egg", 90);
		fl.addFood("Poached Egg", 71);
		fl.addFood("Raw Egg", 72);
		fl.addFood("Egg Whites", 17);
		fl.addFood("Bacon Slice", 40);
		fl.addFood("Pork Roll Slice", 67);
		fl.addFood("Scrapple", 120);
		fl.addFood("Breakfast Sausage Link", 230);
		fl.addFood("Hash Brown", 305);
		fl.addFood("Oatmeal", 158);
		fl.addFood("Cheerios", 102);
		fl.addFood("Honey Nut Cheerios", 105);
		fl.addFood("Whole Grain Cheerios", 100);
		fl.addFood("Frosted Flakes", 111);
		fl.addFood("Fruity Pebbles", 120);
		fl.addFood("Cocoa Pebbles", 119);
		fl.addFood("Cocoa Puffs", 103);
		fl.addFood("Pancake", 86);
		fl.addFood("Waffle", 100);
		fl.addFood("Bagel", 245);
		fl.addFood("Yogurt", 200);

		//Lunch & Dinner
		fl.addFood("Ham and Cheese Sandwich", 352);
		fl.addFood("Peanut Butter and Jelly Sandwich", 160);
		fl.addFood("Peanut Butter", 94);
		fl.addFood("Grape Jelly", 50);
		fl.addFood("Burger", 375);
		fl.addFood("Cheese Steak", 680);
		fl.addFood("Hot Dog (No Bun)", 190);
		fl.addFood("Hot Dog (With Bun)", 300);
		fl.addFood("12-Inch Italian Hoagie", 830);
		fl.addFood("Salad", 235);
		fl.addFood("Grilled Cheese Sandwich", 440);
		fl.addFood("Pizza Slice", 300);
		fl.addFood("Pasta", 221);
		fl.addFood("Meatballs", 284);
		fl.addFood("Italian Sausage Link", 391);
		fl.addFood("Lasagna", 166);
		fl.addFood("Steak (per oz)", 77);
		fl.addFood("Grilled Chicken Breast", 284);
		fl.addFood("Fried Chicken", 320);
		fl.addFood("Chicken Tenders (4 pc)", 185);
		fl.addFood("Chicken Nuggets (5 pc)", 296);
		fl.addFood("Chicken Nuggets (10 pc)", 592);
		fl.addFood("Crab Leg", 130);
		fl.addFood("Lobster", 129);
		fl.addFood("Shrimp", 99);
		fl.addFood("Salmon", 412);
		fl.addFood("Tilapia", 112);
		fl.addFood("Fish Sticks (5 pc)", 410);
		
		//Dessert & Candy
		fl.addFood("Slice of Cheesecake", 401);
		fl.addFood("Slice of Yellow Cake", 242);
		fl.addFood("Slice of Chocolate Cake", 352);
		fl.addFood("Slice of Sponge Cake", 187);
		fl.addFood("Slice of Poundcake", 116);
		fl.addFood("Vanilla Ice Cream", 137);
		fl.addFood("Chocolate Ice Cream", 143);
		fl.addFood("Strawberry Ice Cream", 127);
		fl.addFood("Mint Chocolate Chip Ice Cream", 180);
		fl.addFood("Chocolate Chip Cookie", 78);
		fl.addFood("Oatmeal Raisin Cookie", 65);
		fl.addFood("Sugar Cookie", 74);
		fl.addFood("Peanut Butter Cookie", 95);
		fl.addFood("Oreo", 53);
		fl.addFood("Double Stuffed Oreo", 70);  	
		fl.addFood("Thin Mint", 40);
		fl.addFood("Fortune Cookie", 30);
		fl.addFood("Chocolate Bar", 406);
		fl.addFood("Peanut Butter Cup", 87);
		fl.addFood("Tootsie Roll", 140);
		fl.addFood("Stick of Gum", 11);
		fl.addFood("Skittles", 160);
		fl.addFood("M&Ms", 140);
		fl.addFood("Starburst", 160);
		
		
		//Condiments, Seasonings, Sides, & Ingredients
		fl.addFood("Butter (1 tbsp)", 102);
		fl.addFood("Sugar (1 tbsp)", 48);
		fl.addFood("Salt (1 tbsp)", 0);
		fl.addFood("Ground Black Pepper (1 tbsp)", 17);
		fl.addFood("Ketchup (1 tbsp)", 20);
		fl.addFood("Mustard (1 tbsp)", 3);
		fl.addFood("Marinara Sauce (1 tbsp)", 65);
		fl.addFood("Hot Sauce (1 tbsp)", 0);
		fl.addFood("Honey Mustard (1 tbsp)", 139);
		fl.addFood("Barbecue Sauce (1 tbsp)", 29);
		fl.addFood("Guacamole (1 tbsp)", 100);
		fl.addFood("Ranch Dressing (1 tbsp)", 145);
		fl.addFood("Caesar Dressing (1 tbsp)", 94);
		fl.addFood("Italian Dressing (1 tbsp)", 35);
		fl.addFood("French Dressing (1 tbsp)", 73);
		fl.addFood("Russian Dressing (1 tbsp)", 107);
		fl.addFood("Blue Cheese Dressing (1 tbsp)", 20);
		fl.addFood("Soy Sauce (1 tbsp)", 9);
		fl.addFood("Old Bay Seasoning (1 tbsp)", 2);
		fl.addFood("Cumin (1 tbsp)", 22);
		fl.addFood("Paprika (1 tbsp)", 19);
		fl.addFood("Red Pepper Flakes (1 tbsp)", 1);
		
		//Cheeses
		fl.addFood("Slice of Cheddar Cheese", 113);
		fl.addFood("Slice of American Cheese", 104);
		fl.addFood("Slice of Swiss Cheese", 106);
		fl.addFood("Slice of Mozzarella Cheese", 78);
		fl.addFood("Slice of Provolone Cheese", 98);
		fl.addFood("Slice of Gruyere Cheese", 116);
		fl.addFood("1 oz of Parmesean Cheese", 122);
		fl.addFood("1 oz of Blue Cheese", 100);
		fl.addFood("1 cup of Cottage Cheese", 222);
		
		
		//Snacks
		fl.addFood("Potato Chips (1 oz)", 152);
		fl.addFood("Tortilla Chips (1 oz)", 293);
		fl.addFood("Pretzels (1 oz)", 108);
		fl.addFood("Popcorn (1 oz)", 106);
		fl.addFood("Doritos (1 oz)", 150);
		fl.addFood("Tater Tots", 170);
		fl.addFood("French Fries", 365);
		fl.addFood("Onion Rings", 480);
		fl.addFood("Mozzarella Sticks", 764);
		fl.addFood("Soft Pretzel", 389);				

		//Fruits
		fl.addFood("Strawberry", 4);
		fl.addFood("Blueberries", 84);
		fl.addFood("Apple", 95);
		fl.addFood("Pear", 100);
		fl.addFood("Orange", 47);
		fl.addFood("Banana", 105);
		fl.addFood("Watermelon Slice", 000);
		fl.addFood("Grapes", 62);
		fl.addFood("Grapefruit", 52);
		fl.addFood("Lemon", 17);
		fl.addFood("Lime", 20);
		fl.addFood("Pineapple Slice", 83);
		fl.addFood("Avocado", 234);

		//Vegetables
		fl.addFood("Broccoli", 31);
		fl.addFood("Kale", 33);
		fl.addFood("Lettuce", 10);
		fl.addFood("Green Beans", 31);
		fl.addFood("Asparagus", 3);
		fl.addFood("Onion", 44);
		fl.addFood("Onion Slice", 15);
		

		//Grains
		fl.addFood("White Bread", 79);
		fl.addFood("Multi-Grain Bread", 69);
		fl.addFood("Rye Bread", 65);
		fl.addFood("Pumpernickel Bread", 50);
		fl.addFood("Pita Bread", 165);
		fl.addFood("White Rice", 206);
		fl.addFood("Brown Rice", 216);
		fl.addFood("Wild Rice", 571);

		
		
		//---Drinks---
		
		fl.addFood("Water", 0);
		
		//Breakfast & Juices
		fl.addFood("Whole Milk", 149);
		fl.addFood("2% Milk", 124);
		fl.addFood("1% Milk", 103);
		fl.addFood("Skim Milk", 83);
		fl.addFood("Unsweetened Apple Juice", 113);
		fl.addFood("Sweetened Apple Juice", 117);
		fl.addFood("Orange Juice", 111);
		fl.addFood("Sunny D", 60);
		fl.addFood("Grape Juice", 152);
		fl.addFood("Unsweetened Cranberry Juice", 117);
		fl.addFood("Sweetened Cranberry Juice", 136);
		fl.addFood("Grapefruit Juice", 96);
		fl.addFood("Tomato Juice", 42);
		
		//Sodas (1 can: 12 fl oz)
		fl.addFood("Club Soda", 0);
		fl.addFood("Coca-Cola", 140);
		fl.addFood("Diet Coke", 0);
		fl.addFood("Coke Zero", 0);
		fl.addFood("Coca-Cola Cherry", 150);
		fl.addFood("Pepsi", 150);
		fl.addFood("Diet Pepsi", 0);
		fl.addFood("Cherry Pepsi", 160);
		fl.addFood("Sprite", 192);
		fl.addFood("Sprite Zero", 0);
		fl.addFood("Ginger Ale", 124);
		fl.addFood("Orange Soda", 110);
		fl.addFood("Dr. Pepper", 150);
		fl.addFood("Diet Dr. Pepper", 0);
		fl.addFood("Mountain Dew", 170);
		fl.addFood("A&W Root Beer", 170);
		fl.addFood("Mug Root Beer", 160);

		//Coffee & Such
		fl.addFood("Coffee", 5);
		fl.addFood("Cube of Sugar", 9);
		fl.addFood("Coffee Creamer", 70);
		fl.addFood("Espresso Shot", 3);
		

		fl.addFood("-", 000);

		ExerciseList el = new ExerciseList();
		//aerobic exercises 
		el.addAerobicExercise("Swimming", 150, "20:00");
		el.addAerobicExercise("Running", 250, "20:00");
		el.addAerobicExercise("Skiing", 100, "20:00");
		el.addAerobicExercise("Stair Stepper" , 400, "20:00");
		el.addAerobicExercise("Yoga", 200, "20:00");
		el.addAerobicExercise("Biking", 150, "20:00");
		el.addAerobicExercise("Rowing", 200, "20:00");
		el.addAerobicExercise("Elliptical", 200, "20:00");
		//rep exercises
		el.addRepExercise("Circuit Workout", 3, 9, 500);
		el.addRepExercise("Lifting Weights", 10, 5, 300);
		el.addRepExercise("Lifting Weights", 10, 10, 600);
		el.addRepExercise("HIIT", 5, 7, 400);
		FileIO.serializeLists(el);
		FileIO.serializeLists(fl);
		
		User testUser = new User("Tester", "Hope this works", "Omnipotent", 200000, 10, 10, 2000);
		FileIO.writeUserInfo(testUser);
		DailyLog log1 = new DailyLog(2000);
		DailyLog log2 = new DailyLog(2000);
		
		log1.setDate(LocalDate.of(2020,04,26));
		log1.addFood(testUser.getFoodList().getFood("Scrambled Egg"));
		log1.addFood(testUser.getFoodList().getFood("Sugar Cookie"));
		log1.addFood(testUser.getFoodList().getFood("Cheerios"));
		log1.addExercise(testUser.getExerciseList().getExercise("Rowing"));
		log1.addExercise(testUser.getExerciseList().getExercise("Rowing"));
		
		log2.setDate(LocalDate.of(2020,04,27));
		log2.addFood(testUser.getFoodList().getFood("Skim Milk"));
		log2.addFood(testUser.getFoodList().getFood("Oreo"));
		log2.addFood(testUser.getFoodList().getFood("Pancake"));
		log2.addExercise(testUser.getExerciseList().getExercise("Swimming"));
		log2.addExercise(testUser.getExerciseList().getExercise("Running"));
		
		testUser.getHistory().logDate(log1);
		testUser.getHistory().logDate(log2);
		FileIO.writeUserInfo(testUser);
		
		
		
	}

}
