package finalpackage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;









public class workoutApplication {
	@FXML
	private TableColumn<Workout, Integer> id;
	
	
	@FXML
	private TableView<Workout> Workouts;

	@FXML
	private TableColumn<Workout, String> date;
	@FXML
	private TableColumn<Workout, String> name;
	@FXML
	private TableColumn<Workout, String> location1;
	@FXML
	private Button newWorkout;
	@FXML
	private Button newExercise;
	@FXML
	private Button Submit;
	@FXML
	private TextField TF_Name; 
	@FXML
	private TextField TF_Date; 
	@FXML
	private TextField TF_Exercise; 
	@FXML
	private TextField TF_Sets; 
	@FXML
	private TextField TF_Reps; 
	@FXML
	private TextField TF_Location; 
	
	private ObservableList<Workout> workoutList = FXCollections.observableArrayList();
	private WorkoutSystem system ; 
	private Gym_Workout workout; 
	

	@FXML
	void initialize() {
		
		Path excFile = Paths.get(".\\resource\\Exercise.txt");
		system = new WorkoutSystem(excFile); 
		Path WorkoutFile = Paths
				.get(".\\resource\\Workout.txt");
		loadWorkouts(system, WorkoutFile);
		name.setText("Name");
		date.setText("Date");
		
		id.setText("Workout ID");
		workoutList.addAll(system.getWorkouts());
		Workouts.setItems(workoutList);
		name.setCellValueFactory(new PropertyValueFactory<Workout, String>("name"));
		id.setCellValueFactory(new PropertyValueFactory<Workout, Integer>("id"));

		// Set the cell value factory for the "date" column
		date.setCellValueFactory(new PropertyValueFactory<Workout, String>("datetime"));
		location1.setCellValueFactory(new PropertyValueFactory<Workout, String>("location"));
		Map<String, Exercise> exercises = system.getExercises();
		

				
	
	
		
		
		
	
	
	Workouts.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
	        // check if a row was clicked and the click count is equal to 1
	        if (event.getClickCount() == 1 && Workouts.getSelectionModel().getSelectedItem() != null) {
	            Workout selectedWorkout = Workouts.getSelectionModel().getSelectedItem();
	            Alert alert = new Alert(AlertType.INFORMATION);
	            alert.setTitle("Workout Details");
	            alert.setHeaderText(selectedWorkout.getName() + " - " + selectedWorkout.getDatetime());
	            alert.setContentText(selectedWorkout.workoutDetails() );
	            alert.showAndWait();

	           
	        	
	        }
	    }
	});	
	newWorkout.setOnAction(new EventHandler<ActionEvent>() {
		
	      // order = system.createOnlineOrderOnly();
		@Override
		public void handle (ActionEvent event) {
			TF_Name.setPromptText("Enter User's Name");
			TF_Date.setPromptText("Enter Date of Workout ");
			TF_Location.setPromptText("Enter Gym Location");



		 workout = system.createWorkout();
		 newWorkout.setDisable(true);
	        
	        // Disable add exercise button
	        newExercise.setDisable(true);
	        
	        // Disable exercise, reps, and sets text fields
	        TF_Exercise.setDisable(true);
	        TF_Reps.setDisable(true);
	        TF_Sets.setDisable(true);
	        
	        String name = TF_Name.getText();
	        String date = TF_Date.getText();
	        String location = TF_Location.getText();
	        workout.setDatetime(date);
	        workout.setName(name);
	        workout.setLocation(location);
	        


	        
	        
	        
	        
	        

		}
	});
	
	
	  Submit.setOnAction(event -> {
		  

		   
			newWorkout.setDisable(false);
			
				 workoutList.add(workout);
				Workouts.setItems(workoutList);
			


	  });
	
} //end initialize 
	
	
	
	
	
	
	
	
	
	
	
	

	private static void loadWorkouts(WorkoutSystem system, Path orderDataFile) {
		Map<String, Exercise> exercises = system.getExercises();
		System.out.println(exercises + "EXERCISES AGAIN!");

		try (Scanner input = new Scanner(orderDataFile)) {

			while (input.hasNext()) {
				ArrayList<Exercise> workoutLists = new ArrayList<Exercise>(); 

				Gym_Workout workout = system.createWorkout(); 
				Map<String, Exercise> testing = system.getExercises(); 
				System.out.println("testing" + testing);

				String name = input.next();
				
				input.nextLine(); // finish reading the current line
				
				String date = input.nextLine();
				workout.setDatetime(date);
				workout.setName(name);
				String location = input.nextLine();
				workout.setLocation(location);
				System.out.println("LOCATION " + location);

				int numberOfExercises = input.nextInt(); // finish reading the current line

				System.out.println("Num Exc " + numberOfExercises);
				
				
				for (int i = 0; i < numberOfExercises; i++) {
					String excDescription = input.next();
					System.out.println("Exc name " + excDescription);

					
					
					int reps = system.getReps(excDescription);
					int sets = system.getSets(excDescription);
					Exercise exercise = new Exercise(excDescription, sets, reps); 
					exercise.setSets(10000);

					workoutLists.add(exercise); 
					workout.setAllExercises(workoutLists);
					
				}
				
				//System.out.println("Workout Details " + workout.totalSets()+" " +  workout.workoutDetails());
				
			



			

			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
