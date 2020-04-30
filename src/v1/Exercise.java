package v1;

import java.io.Serializable;

/**
 * The Exercise class is an abstract class to hold information about an exercise. More specific exercise subclasses will be maded and contain more specific information
 * @author Cyan
 *
 */
public abstract class Exercise implements Serializable {

	/**
	 * Just the name
	 */
	private String name;
	private int caloriesBurned;
	public Exercise(String name, int caloriesBurned) {
		this.name = name;
		this.caloriesBurned = caloriesBurned;
	}
	/**
	 * Standard getter for the name field
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Standard setter for the name field
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	
	public void setCaloriesBurned(int newCaloriesBurned) {
		caloriesBurned = newCaloriesBurned;
	}
	
	//Eventually override this so that Rep or Aerobic exercises can display their types?
	/**
	 * Standard toString overload method
	 * @return the name of the exercise as a String
	 */
	public String toString() {
		return name;
	}
	



}
