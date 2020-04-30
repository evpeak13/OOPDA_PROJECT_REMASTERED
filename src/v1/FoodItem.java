package v1;

import java.io.Serializable;

/**
 * Food class to store the information of each food item
 * @author team Cyan
 *
 */
public class FoodItem implements Serializable{
	
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Stores the name
	 */
	private String name;
	
	/**
	 * Stores the calories
	 */
	private int calories;
	
	/**
	 * Constructs a FoodItem from a name and calorie amount 
	 * @param name
	 * @param calories
	 */
	public FoodItem(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	/**
	 * Standard accessor for the name field
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Standard mutator for the name field
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * standard accessor for the calorie field
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}
	
	/**
	 * Standard mutator for the calories fields
	 * @param calories the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	/**
	 * Overloaded toString method
	 * @return a string consisting of the name and calories of the food
	 */
	public String toString() {
		return name + " : " + calories;
	}

}
