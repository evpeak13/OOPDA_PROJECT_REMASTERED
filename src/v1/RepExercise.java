package v1;

import java.io.Serializable;

public class RepExercise extends Exercise implements Serializable {

	private int reps;
	private int intensity;


	public RepExercise(String name, int reps, int intensity, int caloriesBurned) {
		super(name, caloriesBurned);
		this.reps = reps;
		this.intensity = intensity;
	}
	
	public int getReps() {
		return this.reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public int getIntensity() {
		return this.intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
	public String toString() {
		return(super.getName() + " Reps: "+ this.reps + ", intensity: " + this.intensity + ", Calories Burned: "
				      + getCaloriesBurned());
		
	}





}
