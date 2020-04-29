package v1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains health history information about each user, personalized to them
 * @author Cyan
 *
 */
public class History implements Serializable {
	
	/**
	 * Default ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Data corresponding to dates
	 */
	private HashMap<LocalDate, DailyLog> previousDailylogs;
	
	/**
	 * Data from the current day
	 */
	public DailyLog currentDailyLog;
	
	public int calorieLimit;
	
	
	
	/**
	 * Constructs a History object with empty logs and currentLog
	 * @param calorieLimit for the logs
	 */
	public History(int calorieLimit) {
		previousDailylogs = new HashMap<LocalDate, DailyLog>();
		currentDailyLog = new DailyLog(calorieLimit);
		this.calorieLimit = calorieLimit;
	}
	
	
	/**
	 * If it is a new day the old daily log will get pushed to the HashMap and
	 * the new daily log will be saved
	 */
	public void logDate() {
		if(!getCurrentDailyLog().getDate().equals(LocalDate.now())) {
			previousDailylogs.put(getCurrentDailyLog().getDate(), currentDailyLog);
			currentDailyLog = new DailyLog(calorieLimit);
		}
	}
	
	
	/**
	 * Overloaded Version of retrieve date. Uses a LocalDate object as a parameter and compares it to the history
	 * @param date
	 * @return the DailyLog object of the specified date
	 */
	public DailyLog retrieveDate(LocalDate date) {
	
		for(LocalDate key: previousDailylogs.keySet()) {
			if(key.isEqual(date)) {
				return previousDailylogs.get(key);
				
			}
		}
		return null;
	}
	
	
	/**
	 * Standard getter for the currentLog field
	 * @return
	 */
	public DailyLog getCurrentDailyLog() {
		return currentDailyLog;
		
	}
	/**
	 * Standard seetter for the currentLof field
	 * @return
	 */
	public void setCurrentDailyLog(DailyLog today) {
		currentDailyLog = today;
	}
	
	/**
	 * Standard mutator for the calorieLimit field
	 * @param calorieLimit
	 */
	public void setCalorieLimit(int calorieLimit) {
		
		this.calorieLimit = calorieLimit;
	}
	
	
	/**
	 * Standard getter for the calorieLimit field
	 * @return
	 */
	public int getCalorieLimit() {
		
		return this.calorieLimit;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getKeySet() {
		ArrayList<String> dates = new ArrayList<>();
		for(LocalDate l : previousDailylogs.keySet()) {
			dates.add(l.toString());
		}
		return dates;
		
	}
	
	
	
	
	public DailyLog retrieveLog(String date) {
		
		if(containsLog(date)) {
			return previousDailylogs.get(getDate(date));
		}
		return null;
	}
	
	public boolean validDateChecker(String date) {
		if(date.split("/").length == 3) {
			try {
				String[] dateSplit = date.split("/");
				LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]));
			}
			catch(Exception pe) {
				return false;
			}
			return true;
		}
		else if(date.split("-").length == 3) {
			try {
				LocalDate.parse(date);
			}
			catch(Exception pe) {
				return false;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean containsLog(String date) {
		if(validDateChecker(date)) {
			if(previousDailylogs.containsKey(getDate(date))) {
				return true;
			}
		}
		return false;
	}
	
	public LocalDate getDate(String date) {
		if(validDateChecker(date)) {
			if(date.contains("/")) {
				String[] dateSplit = date.split("/");
				return LocalDate.of(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]));
			}
			else {
				return LocalDate.parse(date);
			}
		}
		else {
			return null;
		}
	}
	
	/**
	 * Delete when backend user test is complete
	 */
	public void logDate(DailyLog d) {
		previousDailylogs.put(d.getDate(), d);
	}
}
	


