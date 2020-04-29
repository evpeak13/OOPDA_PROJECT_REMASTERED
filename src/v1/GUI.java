package v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application{

	private static final int sW = 830;
	private static final int sH = 500;
	private static double xSpot = 0.0;
	private static double ySpot = 0.0;
	private static Stage stage;
	private static BorderPane mainPane;
	private static Pane loginPane, btnPane;
	private static Label currentTab;


	private static User currentUser;

	private static BackgroundImage myBI= new BackgroundImage(new Image("background2.png",32,32,false,true),
			BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(830, 500, false, false, true, true)
			);

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start method makes a new application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		setupGUI();
		stage.showAndWait();


	}

	@Override
	public void stop() {
		FileIO.writeUserInfo(currentUser);
		Platform.exit();
		System.exit(0);
	}

	private static void setupGUI() {
		btnPane = makeButtonPane();
		loginPane = makeLoginPane();	
		mainPane = new BorderPane();
		stage = new Stage();
		currentTab = new Label("LOGIN");
		currentTab.setStyle("-fx-font-size: 20px;"
				+ "-fx-font-weight: bold;");

		mainPane.setCenter(loginPane);
		mainPane.setTop(topPane());
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Cyan is god");
		stage.initStyle(StageStyle.UNDECORATED);
		mainPane.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				xSpot = event.getSceneX();
				ySpot = event.getSceneY();
			}
		});

		mainPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(ySpot < 50) {
					stage.setX(event.getScreenX() - xSpot);
					stage.setY(event.getScreenY() - ySpot);
				}   
			}
		});
		stage.setHeight(sW);
		stage.setHeight(sH);
		stage.setMaxWidth(sW);
		stage.setMaxHeight(sH);
		stage.setMinWidth(sW);
		stage.setMinHeight(sH);
		stage.setResizable(false);
		stage.setScene(new Scene(mainPane));

	}

	private static HBox makeLoginPane() {

		HBox pane = new HBox();
		//pane.setStyle("-fx-background-color: #4ED6CB");
		GridPane rightPane = new GridPane();
		rightPane.setVisible(false);
		VBox leftPane = new VBox();
		leftPane.setAlignment(Pos.CENTER);

		Label selectNow = new Label("Select a user:");
		ComboBox<String> userSelection = new ComboBox<String>();
		userSelection.setEditable(true);
		userSelection.setMinWidth(100);
		userSelection.getItems().addAll(FileIO.usernames());		


		Label newUser = new Label("To add a new user fill out these fields and hit 'Add This Profile'");
		TextField txtUserName = new TextField();
		TextField textName = new TextField();
		TextField txtGender = new TextField();
		TextField txtAge = new TextField();
		TextField txtHeight = new TextField();
		TextField txtWeight = new TextField();
		TextField txtCalorieLimit = new TextField();	

		Label lblUserName = new Label("Username:");
		Label lblName = new Label("Name:");
		Label lblGender = new Label("Gender:");
		Label lblAge = new Label("Age (years):");
		Label lblHeight = new Label("Height (inches):");
		Label lblWeight = new Label("Weight (pounds):");
		Label lblCalorieLimit = new Label("Daily Calorie Limit (cal):");	


		Button enterBtn = new Button("Add This Profile");
		Button useUserBtn = new Button("Sign In");
		Button signUp = new Button("Sign Up");


		Label userNotFound = new Label("The entered user does not exist");
		userNotFound.setTextFill(Color.web("#ff0000"));
		userNotFound.setVisible(false);
		Label createUserSuccess = new Label("User Created Successfully");
		createUserSuccess.setVisible(false);

		leftPane.setPadding(new Insets(0, 20, 20, 60));
		leftPane.getChildren().addAll(selectNow, userSelection, useUserBtn, signUp, userNotFound, createUserSuccess);
		leftPane.setMinWidth(200);
		leftPane.setSpacing(10);

		rightPane.setVgap(10);
		rightPane.setHgap(10);
		rightPane.setPadding(new Insets(50, 50, 50, 50));

		rightPane.add(newUser, 0, 0, 3, 1);	

		rightPane.add(lblUserName, 0, 1, 3, 1);
		rightPane.add(lblName, 0, 3);
		rightPane.add(lblGender, 1, 3);
		rightPane.add(lblAge, 2, 3);
		rightPane.add(lblHeight, 0, 5);
		rightPane.add(lblWeight, 1, 5);
		rightPane.add(lblCalorieLimit, 2, 5);

		rightPane.add(txtUserName, 0, 2, 3, 1);
		rightPane.add(textName, 0, 4);
		rightPane.add(txtGender, 1, 4);
		rightPane.add(txtAge, 2, 4);
		rightPane.add(txtHeight, 0, 6);
		rightPane.add(txtWeight, 1, 6);
		rightPane.add(txtCalorieLimit, 2, 6);
		rightPane.add(enterBtn, 1, 7, 3, 1);


		Label createUserError = new Label("The username entered is already taken, please enter a new username");
		createUserError.setTextFill(Color.web("#ff0000"));
		createUserError.setVisible(false);
		rightPane.add(createUserError, 0, 8, 3, 1);

		useUserBtn.setOnAction((event) -> {

			if(FileIO.usernames().contains(userSelection.getValue())) {

				currentUser = (User)FileIO.deserialize("Admin/Users/" + userSelection.getValue() + ".ser");
				currentUser.getHistory().logDate();
				mainPane.setCenter(makeDashboardPane());
				currentTab.setText("DASHBOARD");
				mainPane.setBottom(btnPane);
				FileIO.logLogin(currentUser.getUsername());

				System.err.println("INFO: BMI was claculated to be " + currentUser.getBMI());

			}
			else {
				userNotFound.setVisible(true);
			}

		});

		enterBtn.setOnAction((event) -> {
			if(FileIO.usernames().contains(txtUserName.getText())) {
				//new DuplicateFoundException(txtUserName.getText());
				//createUserError.setText("The username entered is already taken, please enter a new username");
				createUserError.setText((new DuplicateFoundException(txtUserName.getText())).getMessage());
				createUserError.setVisible(true);
				txtUserName.setPromptText(txtUserName.getText());
				txtUserName.clear();
			}
			else {
				try {			
					User user = new User(txtUserName.getText(), textName.getText(), txtGender.getText(), Integer.parseInt(txtAge.getText()), 
							Integer.parseInt(txtHeight.getText()), Integer.parseInt(txtWeight.getText()), Integer.parseInt(txtCalorieLimit.getText()));	

					createUserError.setVisible(false);
					createUserSuccess.setVisible(true);
					FileIO.writeUserInfo(user);
					rightPane.setVisible(false);
					userSelection.getItems().add(txtUserName.getText());
				}
				catch(NumberFormatException e) {
					createUserError.setText("One or more of the values entered are not valid.  Please try again.");
					createUserError.setVisible(true);
				}
			}
		});

		signUp.setOnAction((event) -> rightPane.setVisible(true));


		pane.getChildren().addAll(leftPane, rightPane);

		//then you set to your node
		pane.setBackground(new Background(myBI));

		return pane;	
	}


	private static HBox makeButtonPane() {
		HBox pane = new HBox();
		pane.setStyle("-fx-border-color: black");
		Button historyBtn = new Button("History");

		/**
		historyBtn.addEventHandler(MouseEvent.MOUSE_ENTERED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		            historyBtn.setEffect(new Shadow(5, Color.BLUE));
		          }
		        });
		historyBtn.addEventHandler(MouseEvent.MOUSE_EXITED,
		        new EventHandler<MouseEvent>() {
		          @Override
		          public void handle(MouseEvent e) {
		        	  historyBtn.setEffect(null);
		          }
		        });
		 **/

		Button userBtn = new Button("User");
		Button dashboardBtn = new Button("Dashboard");	
		Button foodBtn = new Button("Food");
		Button exerciseBtn = new Button("Exercises");
		historyBtn.setOnAction(e -> {

			mainPane.setCenter(makeHistoryPane());

			currentTab.setText("HISTORY");

			historyBtn.setDisable(true);
			userBtn.setDisable(false);
			dashboardBtn.setDisable(false);
			foodBtn.setDisable(false);
			exerciseBtn.setDisable(false);
		});
		userBtn.setOnAction(e -> {

			mainPane.setCenter(makeUserPane());
			currentTab.setText("USER SETTINGS");
			historyBtn.setDisable(false);
			userBtn.setDisable(true);
			dashboardBtn.setDisable(false);
			foodBtn.setDisable(false);
			exerciseBtn.setDisable(false);
		});
		dashboardBtn.setOnAction(e -> {

			mainPane.setCenter(makeDashboardPane());
			currentTab.setText("DASHBOARD");
			historyBtn.setDisable(false);
			userBtn.setDisable(false);
			dashboardBtn.setDisable(true);
			foodBtn.setDisable(false);
			exerciseBtn.setDisable(false);
		});
		foodBtn.setOnAction(e -> {mainPane.setCenter(makeFoodPane());
		currentTab.setText("FOOD");
		historyBtn.setDisable(false);
		userBtn.setDisable(false);
		dashboardBtn.setDisable(false);
		foodBtn.setDisable(true);
		exerciseBtn.setDisable(false);
		});
		exerciseBtn.setOnAction(e -> {mainPane.setCenter(makeExercisePane());
		currentTab.setText("EXERCISE");
		historyBtn.setDisable(false);
		userBtn.setDisable(false);
		dashboardBtn.setDisable(false);
		foodBtn.setDisable(false);
		exerciseBtn.setDisable(true);
		});
		ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(historyBtn, userBtn, dashboardBtn, foodBtn, exerciseBtn));
		for (Button btn : buttons) {
			btn.setMinHeight(sH / 6);
			btn.setMinWidth(sW / buttons.size());
			btn.setStyle("-fx-background-insets: 0, 0, 1, 2");
		}
		pane.getChildren().addAll(buttons);
		return pane;
	}

	private static HBox topPane(){
		HBox top = new HBox(300);
		top.setAlignment(Pos.TOP_RIGHT);
		Button close = new Button("Close");
		close.setStyle("-fx-font-size: 20px");
		close.setAlignment(Pos.TOP_RIGHT);
		close.setOnAction(e -> {FileIO.writeUserInfo(currentUser);
		Platform.exit();
		System.exit(0);
		currentTab.setAlignment(Pos.TOP_CENTER);
		});
		top.setBackground(new Background(myBI));
		//top.setStyle("-fx-border-color: black");
		top.setStyle("-fx-background-color: #E0FFFF");
		top.getChildren().addAll(currentTab, close);
		return top;
	}
	/**
	 * Allows the user to view and edit all of their personal information
	 * @return an HBox with all of the information and fields necessary to change the information
	 */
	private static HBox makeUserPane() {
		HBox allSettings = new HBox(30);
		VBox options = new VBox(40);
		VBox textboxes = new VBox(30);
		VBox buttons = new VBox(30);


		Button logOutBtn = new Button("Logout");
		logOutBtn.setMinSize(100, 100);

		logOutBtn.setOnAction(e -> {
			currentUser = null;
			mainPane.setCenter(makeLoginPane());
			btnPane.setVisible(false);
			mainPane.setBackground(new Background(myBI));

		});




		//allSettings.setStyle("-fx-background-color: #25BDB1");

		allSettings.setAlignment(Pos.CENTER);
		options.setAlignment(Pos.CENTER);
		textboxes.setAlignment(Pos.CENTER);
		buttons.setAlignment(Pos.CENTER);

		Label name, gender, age, height, weight, calorieLimit;
		name = new Label("Name: " + currentUser.getName());
		gender = new Label("Gender: " + currentUser.getGender());
		age = new Label("Age: " + currentUser.getAge());
		height = new Label("Height: " + currentUser.getHeight());
		weight = new Label("Weight: " + currentUser.getWeight());
		calorieLimit = new Label("Calorie Limit: " + currentUser.getHistory().getCalorieLimit());

		TextField changeName, changeGender, changeAge, changeHeight, changeWeight, changeCalorieLimit;
		changeName = new TextField();
		changeGender = new TextField();
		changeAge = new TextField();
		changeHeight = new TextField();
		changeWeight = new TextField();
		changeCalorieLimit = new TextField();
		changeName.setPromptText("Enter new name");
		changeGender.setPromptText("Enter new gender");
		changeAge.setPromptText("Enter new age");
		changeHeight.setPromptText("Enter new height");
		changeWeight.setPromptText("Enter new weight");
		changeCalorieLimit.setPromptText("Enter new calorie limit");


		Button setName, setGender, setAge, setHeight, setWeight, setCalorieLimit;
		setName = new Button("Set");
		setGender = new Button("Set");
		setAge = new Button("Set");
		setHeight = new Button("Set");
		setWeight = new Button("Set");
		setCalorieLimit = new Button("Set");

		Label wrongInput = new Label("");
		wrongInput.setPrefWidth(100);
		wrongInput.setWrapText(true);

		setName.setOnAction(e -> {currentUser.setName(changeName.getText());
		name.setText("Name: " + currentUser.getName());
		});

		setGender.setOnAction(e -> {currentUser.setGender(changeGender.getText());
		gender.setText("Gender: " + currentUser.getGender());			
		});


		setAge.setOnAction(e -> {if(checkSettingInput(e, changeAge)) {
			currentUser.setAge(Integer.parseInt(changeAge.getText()));
			age.setText("Age: " + currentUser.getAge());
		}
		else {
			wrongInput.setText("The age value entered is not a number");
		}
		});
		setHeight.setOnAction(e -> {if(checkSettingInput(e, changeHeight)) {
			currentUser.setHeight(Integer.parseInt(changeHeight.getText()));
			height.setText("Height: " + currentUser.getHeight());
			currentUser.setBMI(CalculateBMI.calculate((x, y) -> ((703 * x)/(y * y)),
					currentUser.getWeight(), Integer.parseInt(changeHeight.getText())));
		}
		else {
			wrongInput.setText("The height value entered is not a number");
		}
		});
		setWeight.setOnAction(e -> {if(checkSettingInput(e, changeWeight)) {
			currentUser.setWeight(Integer.parseInt(changeWeight.getText()));
			weight.setText("Weight: " + currentUser.getWeight());
			currentUser.setBMI(CalculateBMI.calculate((x, y) -> ((703 * x)/(y * y)),
					Integer.parseInt(changeWeight.getText()), currentUser.getHeight()));
		}
		else {
			wrongInput.setText("The weight value entered is not a number");
		}
		});
		setCalorieLimit.setOnAction(e -> {if(checkSettingInput(e, changeCalorieLimit)) {
			currentUser.setCalorieLimit(Integer.parseInt(changeCalorieLimit.getText()));
			calorieLimit.setText("Calorie Limit: " + currentUser.getHistory().getCalorieLimit());
		}
		else {
			wrongInput.setText("The calorie limit value entered is not a number");
		}
		});


		options.getChildren().addAll(name, gender, age, height, weight, calorieLimit);
		textboxes.getChildren().addAll(changeName, changeGender, changeAge, changeHeight, changeWeight, changeCalorieLimit);
		buttons.getChildren().addAll(setName, setGender, setAge, setHeight, setWeight, setCalorieLimit);
		allSettings.getChildren().addAll(options, textboxes, buttons, wrongInput, logOutBtn);



		//then you set to your node
		allSettings.setBackground(new Background(myBI));


		return allSettings;
	}



	/**
	 * Checks if a string value is parsable to an int value
	 * @param e action event of a button
	 * @param text the text being checked to see if it is parsable to int
	 * @return true if the string is parsable to int
	 */
	private static boolean checkSettingInput(ActionEvent e, TextField text) {
		try {
			Integer.parseInt(text.getText());
		}
		catch (NumberFormatException nfe){
			return false;
		}
		return true;
	}
	/**
	 * Allows the user to check their daily logs from the past
	 * @return a VBox with all the elements to display the history
	 */
	private static VBox makeHistoryPane() {
		HBox choices = new HBox();
		HBox lists = new HBox(50);
		VBox pane = new VBox();
		
		pane.setAlignment(Pos.TOP_CENTER);
		
		Label timeLbl = new Label("Choose a Date");
		Label calLbl = new Label("");
		Label calBurnLbl = new Label("");
		calLbl.setFont(Font.font("arial", 17));
		timeLbl.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, 17));
		calBurnLbl.setFont(Font.font("arial", 17));
		
		pane.setSpacing(20);

		ComboBox<String> history = new ComboBox<String>();
		history.getItems().addAll(currentUser.getHistory().getKeySet());
		history.setEditable(true);
		history.setPromptText("Enter date here");
		Button b = new Button("Enter");

		Label dateInputError = new Label("The inputted value for date is not a valid date");
		dateInputError.setVisible(false);
		


		lists.setAlignment(Pos.CENTER);
		choices.setAlignment(Pos.CENTER);

		pane.setAlignment(Pos.TOP_CENTER);

		choices.getChildren().addAll(history, b);
		pane.getChildren().addAll(choices, dateInputError, lists, timeLbl, calLbl, calBurnLbl);
		
		//.retrieveLog(history.getValue())
		

		b.setOnAction(e -> {if(currentUser.getHistory().containsLog(history.getValue())) {
			
			ArrayList<PieChart.Data> newList = new ArrayList<PieChart.Data>();
			for(FoodItem food : currentUser.getHistory().retrieveLog(history.getValue()).getFoodsEaten()) {
				newList.add(new PieChart.Data(food.getName(), food.getCalories()));
			}

			ObservableList<PieChart.Data> foodChartData = FXCollections.observableArrayList(newList);         
			PieChart foodChart = new PieChart(foodChartData);
			foodChart.setTitle("Calorie Breakdown");
						
			pane.getChildren().set(5, foodChart);
			
			
			timeLbl.setText("Information for " + currentUser.getHistory().retrieveLog(history.getValue()).getDate().toString());
			calLbl.setText(currentUser.getHistory().retrieveLog(history.getValue()).getcaloriesConsumed()
					+ "/" + currentUser.getHistory().getCalorieLimit() + " Calories consumed");
			calBurnLbl.setText(currentUser.getHistory().retrieveLog(history.getValue()).getExercises().size()
					+" Exercises completed, " + currentUser.getHistory().getCurrentDailyLog().getCaloriesBurned()
					+ " Calories burned");
			dateInputError.setVisible(false);
		}
		else if(!currentUser.getHistory().validDateChecker(history.getValue())){
			dateInputError.setText("The inputted value for the date is not a valid date");
			dateInputError.setVisible(true);
		}
		else {
			dateInputError.setText("The inputted value for the date has no log");
			dateInputError.setVisible(true);
		}
		});


		BackgroundImage myBI= new BackgroundImage(new Image("background2.png",32,32,false,true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(830, 500, false, false, true, true)
				);
		//then you set to your node

		pane.setBackground(new Background(myBI));


		return pane;	
	}


	private static VBox makeDashboardPane() {
		VBox pane = new VBox();

		Label nameLbl = new Label(currentUser.getName() + "'s Dashboard");
		Label timeLbl = new Label("Today is " + currentUser.getHistory().getCurrentDailyLog().getDate().toString());
		Label calLbl = new Label(currentUser.getHistory().getCurrentDailyLog().getcaloriesConsumed() + "/" + currentUser.getHistory().getCalorieLimit() + " Calories consumed");
		Label calBurnLbl = new Label(currentUser.getHistory().getCurrentDailyLog().getExercises().size() +
				" Exercises completed, " + currentUser.getHistory().getCurrentDailyLog().getCaloriesBurned() + " Calories burned");
		pane.setAlignment(Pos.TOP_CENTER);
		nameLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
		nameLbl.setTextFill(Color.BLACK);
		nameLbl.setPadding(new Insets(30, 0, 0, 0));
		nameLbl.setAlignment(Pos.TOP_CENTER);
		//nameLbl.setStyle("-fx-font: 24 arial;");
		calLbl.setFont(Font.font("arial", 17));
		timeLbl.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, 17));
		calBurnLbl.setFont(Font.font("arial", 17));
		pane.setSpacing(20);
		pane.getChildren().addAll(nameLbl, timeLbl, calLbl, calBurnLbl);

		ArrayList<PieChart.Data> foodList = new ArrayList<PieChart.Data>();
		for(FoodItem food : currentUser.getHistory().getCurrentDailyLog().getFoodsEaten()) {
			foodList.add(new PieChart.Data(food.getName(), food.getCalories()));
		}

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(foodList);         
		PieChart foodChart = new PieChart(pieChartData);
		foodChart.setTitle("Calorie Breakdown");
		pane.getChildren().add(foodChart);

		pane.setBackground(new Background(myBI));
		return pane;
	}

	private static BorderPane makeFoodPane() {

		//Left Side

		//Search bar
		TextField search = new TextField();
		search.setOnKeyTyped(e ->{




		});


		//List of Food
		ListView<FoodItem> listview = new ListView<FoodItem>();
		listview.setMaxWidth(200);

		for(FoodItem food: currentUser.getFoodList().getFoods()) {
			listview.getItems().add(food);
		}


		//Button to log food
		Button logFood = new Button("Log");
		logFood.setPadding(new Insets(0,20,0,20));
		logFood.setOnAction(e->{
			currentUser.getHistory().getCurrentDailyLog().addFood(
					listview.getSelectionModel().getSelectedItem());
		});

		//Left side in vbox
		VBox left = new VBox(search, listview, logFood);




		//Right side


		Label name = new Label("Name : ");
		Label calories = new Label("Calories : ");
		Label confirm = new Label();


		TextField enterName = new TextField();
		TextField enterCalories = new TextField();

		//Name
		HBox nameField = new HBox(name, enterName);

		//Calories
		HBox calorieField = new HBox(calories, enterCalories);

		Button addFood = new Button("Add a Food");

		addFood.setOnAction(e->{ 
			if(checkSettingInput(e, enterCalories)) {
				FoodItem food  = new FoodItem(enterName.getText(), Integer.parseInt(enterCalories.getText()));
				if(currentUser.getFoodList().addFood(enterName.getText(), Integer.parseInt(enterCalories.getText()))) {
					System.err.println("ALL FOOD!");
				}
				else {
					System.err.println("lmao nope");
				}
				listview.getItems().add(food);
				confirm.setText("The food has been successfully added!");
			}
			else {
				confirm.setText("Not valid input for a food");
			}

		} );

		//Right side VBox

		VBox right = new VBox(nameField, calorieField, addFood, confirm);

		//Hbox to house left and right
		HBox whole = new HBox(left, right);
		BorderPane panel = new BorderPane();

		panel.setCenter(whole);

		//then you set to your node
		panel.setBackground(new Background(myBI));
		return panel;
	}

	private static BorderPane makeExercisePane() {
		ListView<Exercise> listview = new ListView<Exercise>();
		if(currentUser != null) {
			for(Exercise exercise: currentUser.getExerciseList().getExercises()) {
				listview.getItems().add(exercise);
			}
		}
		Button logExercise = new Button("Log");


		logExercise.setOnAction(e->{
			currentUser.getHistory().getCurrentDailyLog().addExercise(
					listview.getSelectionModel().getSelectedItem());
		});


		Button addExercise = new Button("Add an Exercise");
		addExercise.setOnAction(e->{} );



		//Right side


		Label name = new Label("Name : ");
		Label calories = new Label("Calories : ");
		Label confirm = new Label();


		TextField enterName = new TextField();
		TextField enterCalories = new TextField();

		//Name
		HBox nameField = new HBox(name, enterName);

		//Calories
		HBox calorieField = new HBox(calories, enterCalories);

		Button addFood = new Button("Add a Food");

		addFood.setOnAction(e->{ 
			if(checkSettingInput(e, enterCalories)) {
				Exercise exercise  = new RepExercise(null, 0, 0, 0);
				if(currentUser.getFoodList().addFood(enterName.getText(), Integer.parseInt(enterCalories.getText()))) {
					System.err.println("ALL FOOD!");
				}
				else {
					System.err.println("lmao nope");
				}
				listview.getItems().add(exercise);
				confirm.setText("The food has been successfully added!");
			}
			else {
				confirm.setText("Not valid input for a food");
			}

		} );

		//Right side VBox


		VBox right = new VBox(nameField, calorieField, addFood, confirm);

		//Hbox to house left and right
		HBox whole = new HBox(right, right);
		BorderPane panel = new BorderPane();

		panel.setCenter(whole);

		//then you set to your node
		panel.setBackground(new Background(myBI));
		return panel;
	}

	private static BorderPane makeExercisePane1() {

		//Left Side

		//Search bar



		//List of Exercises
		ListView<Exercise> listview = new ListView<Exercise>();
		listview.setMaxWidth(200);
		for(Exercise exercise: currentUser.getExerciseList().getExercises()) {
			listview.getItems().add(exercise);
			System.out.println(exercise.getCaloriesBurned());
		}

		TextField search = new TextField();
		search.setOnKeyTyped(e ->{
			ListView<Exercise> listNew = new ListView<Exercise>();
			listview.setMaxWidth(415);
			for(Exercise exercise: currentUser.getExerciseList().getExercises()) {
				if(exercise.getName().startsWith(search.getText())) {
					listNew.getItems().add(exercise);
				}

			}
			//listview = listNew;



		});

		//Button to log exercises
		Button logExercise = new Button("Log");
		logExercise.setPadding(new Insets(0,20,0,20));
		logExercise.setOnAction(e->{
			currentUser.getHistory().getCurrentDailyLog().addExercise(
					listview.getSelectionModel().getSelectedItem());
		});

		//Left side in vbox
		VBox left = new VBox(search, listview, logExercise);



		//Right side

		//Aerobic Exercise


		//Labels and textFields for entry
		Label name = new Label("Name ");
		Label duration = new Label("Duration ");
		Label caloriesBurned = new Label("Calories Burned ");

		TextField aname = new TextField();
		TextField aduration = new TextField();
		TextField acaloriesBurned = new TextField();

		//HBoxes for grouping
		HBox enterAName = new HBox(name, aname);
		HBox enterADuration = new HBox(duration, aduration);
		HBox enterACaloriesBurned = new HBox(caloriesBurned, acaloriesBurned);

		//Button for logging aerobic exercise
		Button logAerobicExercise = new Button("Log Exercise");
		logAerobicExercise.setOnAction(e ->{
			if(checkSettingInput(e, acaloriesBurned) && aduration.getText().length() == 5 && aduration.getText().contains(":"))
			{
				Exercise exercise  = new AerobicExercise(aname.getText(), aduration.getText(), Integer.parseInt(acaloriesBurned.getText()));
				currentUser.getExerciseList().getExercises().add(exercise);
				listview.getItems().add(exercise);
			}
		});

		//Rep exercise

		Label nameR = new Label("Name ");
		Label repsR = new Label("Reps ");
		Label intensityR = new Label("Intensity ");
		Label caloriesBurnedR = new Label("Calories Burned ");

		TextField enterRName = new TextField();
		TextField enterRReps = new TextField();
		TextField enterRIntensity = new TextField();
		TextField enterRCaloriesBurned = new TextField();

		//HBoxes for grouping
		HBox nameGroupR = new HBox(nameR, enterRName);
		HBox repsGroupR = new HBox(repsR, enterRReps);
		HBox intensityGroupR = new HBox(intensityR, enterRIntensity);
		HBox caloriesBurnedGroupR = new HBox(caloriesBurnedR, enterRCaloriesBurned);

		//Button for logging Rep Exercise
		Button logRepExercise = new Button("Log Exercise");
		logRepExercise.setOnAction(e ->{
			if(checkSettingInput(e, enterRReps) && checkSettingInput(e, enterRIntensity) && checkSettingInput(e, enterRCaloriesBurned))
			{
				Exercise exercise  = new AerobicExercise(enterRName.getText(), enterRReps.getText(), Integer.parseInt(enterRCaloriesBurned.getText()));
				currentUser.getExerciseList().getExercises().add(exercise);
				listview.getItems().add(exercise);
			}
		});

		VBox right = new VBox(enterAName, enterADuration, enterACaloriesBurned, logAerobicExercise
				,nameGroupR, repsGroupR, intensityGroupR, caloriesBurnedGroupR, logRepExercise);

		HBox whole = new HBox(left, right);
		BorderPane panel = new BorderPane();
		panel.setCenter(whole);
		panel.setBackground(new Background(myBI));
		return panel;


	}


} 
