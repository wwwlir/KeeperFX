package keepapp.view;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class MainLayoutController {

	private InitUI initUI;

	public void setMainApp(InitUI initUI) {
        this.initUI = initUI;
    }
	@FXML
	private void inicialize(){
		
	}
	@FXML
	private void showPersonView(){
		initUI.showPersonLayout();
	}
	@FXML
	private void showMainView(){
		initUI.showMainLayout();
	}
	
	
	public void setLayout(AnchorPane pane){
		AnchorPane anchorMain = new AnchorPane();
		
		
		
		GridPane gridPaneDay = new GridPane();
		gridPaneDay.setAlignment(Pos.CENTER);
		gridPaneDay.setGridLinesVisible(false);
		gridPaneDay.setHgap(10);
		gridPaneDay.setVgap(10);
		
//		GridPane gridPaneList = new GridPane();
		
		LocalDate nowDate = LocalDate.now();
		LocalDate startmouth = nowDate .with(TemporalAdjusters.firstDayOfMonth());
		DayOfWeek dayWeek = startmouth.getDayOfWeek();
		LocalDate calDay = startmouth.minusDays(dayWeek.getValue()-1);
		int nowNumDay = nowDate.getDayOfMonth();
			
		gridPaneDay.add(new Label("ом"), 0, 0);
		gridPaneDay.add(new Label("бр"), 1, 0);
		gridPaneDay.add(new Label("яп"), 2, 0);
		gridPaneDay.add(new Label("вр"), 3, 0);
		gridPaneDay.add(new Label("ор"), 4, 0);
		gridPaneDay.add(new Label("яа"), 5, 0);
		gridPaneDay.add(new Label("бя"), 6, 0);
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Label label = new Label(Integer.toString(calDay.getDayOfMonth()));
				if (calDay.isEqual(nowDate)) {
					label.setStyle("-fx-font: bold italic 12pt Georgia; -fx-background-color: lightgreen;");
				}
				gridPaneDay.add(label, j, i);
				calDay = calDay.plusDays(1);
			}
		}
		anchorMain.getChildren().add(gridPaneDay);
		anchorMain.setTopAnchor(gridPaneDay, 10.0);
		
//		borderMain.setRight(gridPaneDay);
//		borderMain.setCenter(gridPaneList);
		pane.getChildren().add(anchorMain);
		pane.setRightAnchor(anchorMain, 10.0);
	}
}
