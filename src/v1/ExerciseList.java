package v1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class built to maintain and manipulate the list of exercises the users has to choose from
 * @author Cyan
 *
 */
public class ExerciseList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795716215122518024L;
	/**
	 * Stores all the exercises
	 */
	private ArrayList<Exercise> exercises;
	
	/**
	 * Constructs a new Exercise list
	 */
	public ExerciseList() {
		this.exercises = new ArrayList<Exercise>();
		
	}
	
	/**
	 * Standard getter for the exercises field
	 * @return
	 */
	public ArrayList<Exercise> getExercises(){
		return this.exercises;
		
	}
	
	/**
	 * Standard setter for the exercises field
	 * @param newExercises
	 */
	public void setExercises(ArrayList<Exercise> newExercises) {
		this.exercises = newExercises;
		
	}
	
	/**
	 * Adds an exercise to the list from the passed Exercise object
	 * @param newExercise
	 * @return a boolean on whether or not the exercise was successfully added
	 */
	public boolean addExercise(Exercise newExercise) {
		boolean noDupe = true;
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(newExercise.getName())) {
				noDupe = false;
			}}
		
		if(noDupe) {
			exercises.add(newExercise);
			return noDupe;
		}
		else {
			return noDupe;
		}
	}
		

	/**
	 * Specifies an aerobic exercise to add to the Exercise list
	 * @param name
	 * @param caloriesBurned
	 * @param duration
	 * @return a boolean on whether the exercise was successfully added
	 */
	public boolean addAerobicExercise(String name, int caloriesBurned, String duration) {
		boolean noDupe = true;
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name)) {
				noDupe = false;
			}}
		
		if(noDupe) {
			exercises.add(new AerobicExercise(name, duration, caloriesBurned));
			return noDupe;
		}
		else {
			return noDupe;
		}
	}
	
	/**
	 * Specifies a rep exercise to add to the Exercise list
	 * @param name
	 * @param reps
	 * @param intensity
	 * @param caloriesBurned
	 * @return a boolean on whether the exercise was successfully added
	 */
	public boolean addRepExercise(String name, int reps, int intensity, int caloriesBurned) {
		boolean noDupe = true;
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name)) {
				noDupe = false;
			}}
		
		if(noDupe) {
			exercises.add(new RepExercise(name,reps, intensity, caloriesBurned));
			return noDupe;
		}
		else {
			return noDupe;
		}
	}
	
	/**
	 * Deletes an exercise with the specified name
	 * @param name
	 * @return a boolean, true if successfully found and deleted. False if otherwise
	 */
	public boolean deleteExercise(String name) {
		Exercise ref = null;
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name)) {
				ref = exercise;
			}}
		if(ref!= null) {
		exercises.remove(ref);
		return true;
		}
		else {
			return false;
		}
		}
	

		
	/**
	 * Returns an exercise with the specified name
	 * @param name
	 * @return the exercise as an Exercise object
	 */
	public Exercise getExercise(String name) {
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name)) {
				return exercise;
			}
			
		}
		
		return null;
		
	}
	
	/**
	 * Specifies an Aerobic exercise to get returned. null if no Aerboci exercise with the passed name is found
	 * @param name
	 * @return the found Aerobic exercise
	 */
	public AerobicExercise getAerobicExercise(String name) {
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name) && (exercise instanceof AerobicExercise)) {
				return (AerobicExercise)exercise;
			}
			
		}
		
		return null;
		
	}
	
	
	/**
	 * Gets an RepExercise of the specified name from the exercise list
	 * @param name
	 * @return the found RepExercise
	 */
	public RepExercise getRepExercise(String name) {
		for(Exercise exercise: exercises) {
			if(exercise.getName().equals(name) && (exercise instanceof RepExercise)) {
				return (RepExercise)exercise;
			}
			
		}
		
		return null;
	}
}
