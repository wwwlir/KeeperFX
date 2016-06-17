package keepapp.view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import keepapp.MainApp;

public class RootLayoutController {

    private InitUI initUI;

    public void setMainApp(MainApp mainApp) {
    }
    public void setInitUI(InitUI initUI){
    	this.initUI = initUI;
    }

    @FXML
    private void handleNew() {
    }

    @FXML
    private void handleOpen() {
    }

    @FXML
    private void handleSave() {
    }

    @FXML
    private void handleSaveAs() {
    }

    @FXML
    private void handleAbout() {
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void handleSetting(){
    	initUI.showSettingsEditDialog();
    }
    
    @FXML
    public void showMainView(){
    	initUI.showMainLayout();		
    }
    @FXML
	private void showPersonView(){
    	initUI.showPersonLayout();
//    	final Task task = new Task<Void>() {
//
//			@Override
//			protected Void call() throws Exception {
//				// TODO Auto-generated method stub
//				initUI.showPersonLayout();
//				return null;
//			}
//		};
    	
//		new Thread(task).start();
		
//		Service service = new Service<Void>() {
//			@Override
//			protected Task createTask() {
//				// TODO Auto-generated method stub
//				return task;
//			}
//			
//		};
//		service.start();
		
//		ExecutorService es = Executors.newSingleThreadExecutor();
//		es.submit(task);
//		es.shutdown();
	}
    @FXML
	private void showKeePassView(){
		initUI.showKeePassLayout();
	}
    @FXML
	private void showKeeLinkView(){
		initUI.showKeeLinkLayout();
	}
    @FXML
	private void showNoteView(){
    	initUI.showNoteLayout();
	}
    @FXML
	private void showPlanDayView(){
    	initUI.showPlanDayLayout();
	}
//end
}