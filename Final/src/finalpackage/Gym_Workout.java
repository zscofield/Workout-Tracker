package finalpackage;

import java.util.Calendar;

public class Gym_Workout extends Workout{
private String location;
	public Gym_Workout(String name, String datetime , String location , int id) {
		super(name , datetime, id);
		this.setLocation(location);
		
	}
	
	

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAdditionalInfo() {
		return "Location: " + location+ "\n";
	}
	

}
