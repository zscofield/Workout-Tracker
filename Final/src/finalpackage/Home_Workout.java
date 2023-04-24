package finalpackage;

import java.util.Calendar;

public class Home_Workout extends Workout {
	private String type;
	public Home_Workout(String name, String datetime , int id , String typeOfLift) { //type of lift specifies calisthenics or Weights or Cardio
		super(name , datetime, id);
		this.type = typeOfLift;
	}
	@Override
	public String getAdditionalInfo() {
		// TODO Auto-generated method stub
		return this.type ;
	}
}
