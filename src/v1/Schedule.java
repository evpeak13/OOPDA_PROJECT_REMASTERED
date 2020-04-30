package v1;

import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Keeps track of all scheduleable exercises for the user
 * @author Cyan
 *
 */
public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Exercise, LocalTime[]> schedule;
	
	public Schedule() {
		this.schedule = new HashMap<Exercise, LocalTime[]>();
	}
	
	/**
	 * Adds the exercise to the schedule if it does not conflict with any of the other times
	 * @param newExercise
	 * @param times
	 */
	public void addToSchedule(Exercise newExercise, LocalTime[] times) {
		boolean fits = true;
		for(Exercise key: schedule.keySet()) {
			if(fits == true && schedule.get(key)!= null && !(schedule.get(key)[0].isAfter(times[1]) || schedule.get(key)[1].isBefore(times[0]) )) {
				fits = false;
			}

			
		}
		if(fits) {
			schedule.put(newExercise, times);
		}
		
	}
	
	/**
	 * removes an exercise with the specified name from the schedule
	 * @param name
	 */
	public void removeFromSchedule(String name) {
		Exercise ref = null;
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				ref = key;
			}
		}
		
		if(ref!= null) {
			schedule.remove(ref);
		}
		
		
	}
	
	/**
	 * Changes the times of a current exercise in the schedule
	 * @param name
	 * @param newTimes
	 */
	public void changeExerciseTime(String name, LocalTime[] newTimes) {
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				addToSchedule(key, newTimes);
			}
		}
		
	}
	
	/**
	 * Standard setter for the schedule field
	 * @param newSchedule
	 */
	public void setSchedule(HashMap<Exercise, LocalTime[]> newSchedule) {
		this.schedule = newSchedule;
	}
	
	/**
	 * Standard getter for the schedule field
	 * @return schedules
	 */
	public HashMap<Exercise, LocalTime[]> getSchedule(){
		return this.schedule;
	}
	
	public static LocalTime convertToMilitary(String time, String ampm) {
		String[] times = time.split(":");
		if(ampm.equals("am")) {
			return LocalTime.of(Integer.parseInt(times[0])%24, Integer.parseInt(times[1]));
		}
		else {
			return LocalTime.of(Integer.parseInt(times[0])+ 12, Integer.parseInt(times[1]));
		}
	}
	
	public String toString() {
		//for(Exercise exercise: this.getSchedule())
		return null;
	}
	
	
	
}
