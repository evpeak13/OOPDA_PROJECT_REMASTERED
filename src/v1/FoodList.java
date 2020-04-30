package v1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class built to store, maintain, and manipulate a list of foods that the user is able to choose from
 * @author Cyan
 *
 */
public class FoodList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1882253241654639752L;
	/**
	 * stores the FoodItems
	 */
	private ArrayList<FoodItem> foods;
	
	/**
	 * Constructor for the FoodList object
	 */
	public FoodList() {
		this.foods = new ArrayList<FoodItem>();
		
	}
	
	/**
	 * Standard getter for the foods field
	 * @return
	 */
	public ArrayList<FoodItem> getFoods(){
		return this.foods;
		
	}
	
	/**
	 * Standard setter for the foods field
	 * @param newFoods
	 */
	public void setFoods(ArrayList<FoodItem> newFoods) {
		this.foods = newFoods;
		
	}
	
	/**
	 * Makes a new FoodItem object then adds it to the foods field. Does not add if another food with the same name is already contained in the list
	 * @param name
	 * @param calories
	 * @return true if successful, false if unsuccessful
	 */
	public boolean addFood(String name, int calories) {
		boolean noDupe = true;
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				noDupe = false;
			}}
		
		if(noDupe) {
			foods.add(new FoodItem(name, calories));
			return noDupe;
		}
		else {
			return noDupe;
		}
	}
	
	
	/**
	 * removes the FoodItem with the specified name from the list
	 * @param name
	 * @return true if deletion was successful, false if unsuccessful
	 */
	public boolean deleteFood(String name) {
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				foods.remove(food);
				return true;
			}}
		return true;
		}
	
	/**
	 * Returns a food with the specified name from the list
	 * @param name
	 * @return The desired FoodItem
	 */
	public FoodItem getFood(String name) {
		
		for(FoodItem food: foods) {
			if(food.getName().equals(name)) {
				return food;
			}
			
		}
		
		return null;
		
	}
	
}
