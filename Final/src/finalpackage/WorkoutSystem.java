package finalpackage;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;






public class WorkoutSystem{
	private static Map<String , Exercise> exercises = new HashMap<>();
	private static int id; 
	private List<Gym_Workout> wrkout = new ArrayList<>();

public WorkoutSystem(Path pathToItemDataFile) {

try (Scanner input = new Scanner(pathToItemDataFile)) {
while(input.hasNext()) {
String name  = input.next();
System.out.println("name" + name);
int reps = input.nextInt();
System.out.println("reps" + reps);

int sets = input.nextInt();
System.out.println("sets" + sets);

int rpe = input.nextInt();
System.out.println("rpe" + rpe);

Exercise exercise = new Exercise(name, reps , sets ); 
exercise.setDifficulty(rpe);
exercises.put(name, exercise);





}
}
catch(Exception e) {
	e.printStackTrace();
	}
	for (String name : exercises.keySet()) {
		System.out.println(exercises.get(name).getExerciseName());
}
		System.out.println("Loaded Exercises! \n\n");
}


public Gym_Workout createWorkout() {
	Gym_Workout workout = new Gym_Workout("name" , "datetime" , "location", id++);
	wrkout.add(workout);
			return workout;
	
}



public Map<String, Exercise> getExercises() {
	return exercises;
}
public String setName( String name) {
	return exercises.get(name).getExerciseName(); 
}
public int getReps(String itemName) {
return exercises.get(itemName).getReps();

}
public int getSets(String itemName) {
return exercises.get(itemName).getSets();
}

public RPE getRpe(String itemName) {
return exercises.get(itemName).getCategory();
}
public List<Gym_Workout> getWorkouts() {
return wrkout;
}
public String getExerciseName(String name) {
    Exercise exercise = exercises.get(name);
    if (exercise != null) {
        return exercise.getExerciseName();
    } else {
        return null;
    }
}

}

