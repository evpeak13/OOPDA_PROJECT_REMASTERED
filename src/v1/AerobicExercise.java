package v1;
import java.io.Serializable;
import java.time.LocalTime;
public class AerobicExercise extends Exercise implements Scheduleable, Serializable{

	private int[] duration;

	/**
	 * Constructor for the Cardio Exercise
	 * @param name
	 * @param duration, formatted in 'hh:mm'
	 */
	public AerobicExercise(String name, String duration, int caloriesBurned)  {
		super(name, caloriesBurned);
		this.duration = new int[2];
		String[] times = duration.split(":");
		this.duration[0] = Integer.parseInt(times[0]);
		this.duration[1] = Integer.parseInt(times[1]);
	}
	
	
	/**
	 * returns the start time and the end time of a passed exercise when started at the time passed to the method
	 * @param exercise the exercise that needs to be scheduled
	 * @param startTime the time for the exercise to start
	 * @return A LocalTime array. element [0] is the start time and element [1] is the end time
	 */
	public LocalTime[] schedule(AerobicExercise exercise, LocalTime startTime){
		LocalTime[] times = new LocalTime[2];
		times[0] = startTime;
		times[1] = startTime.plusHours(this.duration[0]).plusMinutes(this.duration[1]);
		return times;
		

	}
	
	/**
	 * Standard mutator for the duration private field
	 * @param duration as a string, formatted as 'hh:mm' 
	 */
	public void setDuration(String duration) {
		String[] time = duration.split(":");
		this.duration[0] = Integer.parseInt(time[0]);
		this.duration[1] = Integer.parseInt(time[1]);
		
	}
	
	/**
	 * Standard accessor for the duration private field
	 * @return an array of ints, element[0] is the hours field and element [1] is the minutes field
	 */
	public int[] getDuration() {
		return this.duration;
		
	}
	
	/**
	 * Overrides the standard toString method
	 * @return small, detailed string of the class. Includes name and duration
	 */
	public String toString() {
		return (getName() + ", Duration- " + this.duration[0] + ":" + this.duration[1] + ", Calories Burned: "
				+ getCaloriesBurned());
	}

}
