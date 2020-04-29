module fitnessApp {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires java.logging;
	
	opens v1 to javafx.fxml;
	exports v1;
}	