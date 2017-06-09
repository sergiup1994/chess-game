import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ChessApplication extends Application {
	@Override
	public void init() {
		// initialize the layout of the board
		sp_mainlayout = new StackPane();
		cc_custom = new CustomControl();
		sp_mainlayout.getChildren().add(cc_custom);
		
		//create the timer
        timer1.textProperty().bind(Minutes1.asString());
        timer1.setStyle("-fx-font-size: 1.5em;");
        timer2.textProperty().bind(Minutes2.asString());
        timer2.setStyle("-fx-font-size: 1.5em;");
        
        //create the buttons 
		btn1 = new Button("START");
		btn2 = new Button("STOP");
		btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn1.setOnAction(new EventHandler<ActionEvent>() {
	
		@Override
		public void handle(ActionEvent event) {
				   if (time != null && type == 1){
	                    time1 = Duration.ZERO;
	                    Minutes1.set(time1.toSeconds());
	                } 
				   else {
	                    time = new Timeline(
	                        new KeyFrame(Duration.seconds(1),
	                        new EventHandler<ActionEvent>() {
	                            @Override
	                            public void handle(ActionEvent t) {
	                                Duration duration = ((KeyFrame)t.getSource()).getTime();
	                                time1 = time1.add(duration);
	                                Minutes1.set(time1.toSeconds());
	                            }
	                        })
	                    );
	                    
	                    time.setCycleCount(900);
	                    time.play();
	                }
				   
				   if (time2 != null && type == 2){
	                    Time2 = Duration.ZERO;
	                    Minutes2.set(Time2.toSeconds());
	                } 
				   else {
	                    time2 = new Timeline(
	                        new KeyFrame(Duration.seconds(1),
	                        new EventHandler<ActionEvent>() {
	                            @Override
	                            public void handle(ActionEvent t) {
	                                Duration duration = ((KeyFrame)t.getSource()).getTime();
	                                Time2 = Time2.add(duration);
	                                Minutes2.set(Time2.toSeconds());
	                            }
	                        })
	                    );
	                    time2.setCycleCount(900);
	                    time2.play();
	                }
	                
				}
	});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	
		@Override
		public void handle(ActionEvent event) {
				time.stop();
				time2.stop();
		}
	});
	
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Emmet phelan 2865284 - Sergiu Popusoi 2861829");
		BorderPane bp = new BorderPane();
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.getChildren().addAll(timer2);
		vb1.setStyle("-fx-background-color:  #a65959");
	    vb2.setAlignment(Pos.CENTER);
		vb2.getChildren().addAll(timer1);
		vb2.setStyle("-fx-background-color: #a65959	");
		primaryStage.setScene(new Scene(bp, 800, 800 ));
		bp.setCenter(sp_mainlayout);
		bp.setTop(vb1);
		bp.setBottom(vb2);
		bp.setLeft(btn1);
		bp.setRight(btn2);
		primaryStage.show();
	}

	
	@Override
	public void stop(){}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// private values for this class
	private StackPane sp_mainlayout;
	private CustomControl cc_custom;	
	private Button btn1, btn2;
    private int type;
    private Label timer1 = new Label();
	private Label timer2 = new Label();
	private Timeline time;
	private Timeline time2;
    private DoubleProperty Minutes1 = new SimpleDoubleProperty(),
    		Minutes2 = new SimpleDoubleProperty();
	private Duration time1 = Duration.ZERO, 
			Time2 = Duration.ZERO;

	
}