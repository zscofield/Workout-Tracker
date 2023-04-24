package finalpackage;


public class Exercise {
private int reps;
int sets;
private String exerciseName;
private RPE rpe; 
private int number;
public Exercise( String name  , int reps , int sets ) {
	this.reps = reps;
	this.sets = sets;
	this.exerciseName = name;
	
}
public int getReps() {
	return reps;
}
public void setReps(int reps) {
	this.reps = reps;
}
public int getSets() {
	return sets;
}
public void setSets(int sets) {
	this.sets = sets;
}
public String getExerciseName() {
	return exerciseName;
}
public void setExerciseName(String exerciseName) {
	this.exerciseName = exerciseName;
}
public RPE getRpe() {
	return rpe;
}
public void setRpe(RPE rpe) {
	this.rpe = rpe;
}
public void setDifficulty(int number) {
	this.number = number;
	
	this.rpe =RPE.defineCategory(this.number);
}

public RPE getCategory() {
	return this.rpe;
}


}
