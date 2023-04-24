package finalpackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




public abstract class Workout implements WorkoutSummary {
private String name;
private String datetime ;
private int id; 
private ArrayList<Exercise> allExercises ;
private int total; 
private Exercise exercise; 

	public Workout(String name , String dateTime , int id ) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.datetime = dateTime;
		this.id = id; 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String time) {
		this.datetime = time;
	}

	public List<Exercise> getAllExercises() {
		return allExercises;
	}

	public void setAllExercises(ArrayList<Exercise> allExercises) {
		this.allExercises = allExercises;
	}
	public String getExerciseName(String exercise) {
	    for (int i = 0;  i < allExercises.size(); i++) {
	        if (allExercises.get(i).getExerciseName().equals(exercise)) {
	            return allExercises.get(i).getExerciseName();
	        }
	    }
	    return null; // exercise name not found
	}
	@Override
	public int totalSets() {
		
		for (int i = 0;  i < allExercises.size(); i++) {
			Exercise exercise = allExercises.get(i);
			
			total += exercise.getSets();
		}
		System.out.println(total);

		return total;
		
	}
	public abstract String getAdditionalInfo();

	@Override
	public String workoutDetails() {
		
		String details = getAdditionalInfo();
			
		int j = 0;

		// create a copy of the allExercises list
		List<Exercise> exercisesCopy = new ArrayList<>(allExercises);

		for (Exercise exercise : exercisesCopy) {
			j++;
			details += " Exercise " + j + "." + exercise.getExerciseName() + " " ; 
		}
		
		System.out.println("Workout Details: " + "Name: " + this.name + " " + details + " Total Sets: " + this.totalSets() + " Date: " + this.datetime ); 

		return details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
