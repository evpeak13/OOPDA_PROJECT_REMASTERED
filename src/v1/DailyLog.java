package v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * More accessible daily log information, before it is transferred to the History class for more concrete storage
 * @author Cyan
 *
 */
public class DailyLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2602357011051485005L;
	LocalDate date;
    int caloriesConsumed, calorieLimit, caloriesBurned;
    ArrayList<FoodItem> foodsEaten;
    ArrayList<Exercise> exercises;
    /**
     * Constructor for a daily log
     * @param calorieLimit the calorie limit for the day
     */
    public DailyLog(int calorieLimit) {
        date = LocalDate.now();
        this.calorieLimit = calorieLimit;
        caloriesConsumed = 0;
        caloriesBurned = 0;
        foodsEaten = new ArrayList<>(5);
        exercises = new ArrayList<>(5);
    }

	
	public ArrayList<FoodItem> getFoodsEaten() {
		return foodsEaten;
	}


	public void setFoodsEaten(ArrayList<FoodItem> foodsEaten) {
		this.foodsEaten = foodsEaten;
	}


	/**
	 * Standard getter for calories burned
	 * @return calories burned as an int
	 */
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}


	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}


	/**
	 * Standard setter for calories burned
	 * @param caloriesBurned
	 */
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	
	/**
	 * standard getter for calories total
	 * @return claories limit as an int
	 */
	public int getcalorieLimit() {
		return calorieLimit;
	}

	/**
	 * standard setter for  Calorie limit
	 * @param caloriesTotal
	 */
	public void setcalorieLimit(int caloriesTotal) {
		this.calorieLimit = caloriesTotal;
	}

	/**
	 * standard getter for calories eaten
	 * @return calories eaten as an int
	 */
	public int getcaloriesConsumed() {
		return caloriesConsumed;
	}

	/**
	 * standard setter for calories eaten
	 * @param caloriesConsumed
	 */
	public void setcaloriesConsumed(int caloriesConsumed) {
		this.caloriesConsumed = caloriesConsumed;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Delete when finished with backend user test
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Formats the calorie information in a proper way
	 * @return formatted string to be used in the GUI
	 */
	public String basicInfo() {
        return "Date: " + date + 
                "\nCalories Consumed: " + caloriesConsumed + "/" + calorieLimit +
                "\nCalories Burned: " + caloriesBurned;
    }
	
	/**
	 * Adds a food to the foods eaten as well as the calories it contains
	 * @param food the food item being added
	 */
    public void addFood(FoodItem food) {
        foodsEaten.add(food);
        caloriesConsumed += food.getCalories();
    }
    
    /**
     * Adds an exercise to the exercises completed today
     * @param exercise the exercise being added to the list
     */
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        caloriesBurned += exercise.getCaloriesBurned();
    }
    
    /**
     * Formats the list of foods into a line by line string
     * @return formatted string of foods
     */
    public String foodInfo() {
    	String foods = "";
    	if(foodsEaten.size() == 0) {
    		foods = "No Foods Recorded";
    	}
        for(FoodItem food : foodsEaten) {
            foods = foods + food.toString() + "\n";
        }
        return foods;
    }
    /**
     * Formats the list of exercises into a line by line string
     * @return formatted string of exercises
     */
    public String exerciseInfo() {
        String workouts = "";
        if(exercises.size() == 0) {
    		workouts = "No Exercises Recorded";
    	}
        for(Exercise exercise : exercises) {
            workouts = workouts + exercise.toString() + "\n";
        }
        return workouts;
    }

}
