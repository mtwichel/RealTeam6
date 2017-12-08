package esof322.pa4.Team6.gui;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class PlayerSetUpWindow extends Application {

	private int players;
	private ComboBox<Sequence> combo;
	
    public PlayerSetUpWindow() {
        //Application.launch(args);
        start(new Stage());
    }

    private ObservableList<Sequence> sequences;


    class Sequence {
        public StringProperty name = new SimpleStringProperty();
        
        public Sequence(String name) {
            super();
            this.name.set(name);
        }

        @Override
        public String toString() {
            return "null";
        }
    }
    
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Hello World");

        Group root1 = new Group();

        final Scene scene1 = new Scene(root1, 383, 250);

        players = 4;
        
        Callback<Sequence, Observable[]> extractor = new Callback<Sequence, Observable[]>() {
            @Override
            public Observable[] call(Sequence s) {
                return new Observable[] {s.name};
            }
        };
        sequences = FXCollections.observableArrayList(extractor);
        sequences.addAll(
                new Sequence("Player1"),
                new Sequence("Player2"),
                new Sequence("Player3"),
                new Sequence("Player4"));

        combo = new ComboBox<>();
        combo.setItems(sequences);
        combo.getSelectionModel().selectFirst();
        combo.setConverter(new StringConverter<PlayerSetUpWindow.Sequence>() {
            @Override
            public String toString(Sequence sequence) {
                return sequence.name.get();
            }

            @Override
            public Sequence fromString(String string) {
                System.out.println("call fromString");
                return null;
            }
        });
        combo.valueProperty().addListener((obs, oldValue, newValue) -> System.out.println("Change from " + oldValue.name.get() + " to " + newValue.name.get())); 

        TextField text = new TextField();
        Button renameButton = new Button("Rename");

        renameButton.setOnAction(evt -> {
            combo.getValue().name.set(text.getText());
        });

        HBox root = new HBox(combo, text, renameButton);
        HBox.setHgrow(text, Priority.ALWAYS);
        root.setPadding(new Insets(10, 10, 10, 10));
        
		Button minus = new Button("-");
        minus.setOnAction(e -> {
        	if(players>2) {
        		players--;
        		sequences.remove(players);
        	}else {
        		//POPUPWINDOW THING HERE
        	}
        });
        
        Button plus = new Button("+");
        plus.setOnAction(e -> {
        	if(sequences.size()<4) {
        		players++;
        		sequences.add(new Sequence("Player"+players));
        	}else {
        		//POPUPWINDOW THING HERE
        	}
        });
		
        HBox plusMinus = new HBox();
        plusMinus.getChildren().addAll(plus,minus);
        plusMinus.setAlignment(Pos.CENTER);
        plusMinus.setPadding(new Insets(10, 10, 10, 10));
        
        Button startGame = new Button();
        startGame.setLayoutX(100);
        startGame.setLayoutY(80);
        startGame.setText("Ready to Start Game!");
        
        startGame.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
            	//Set player names in Facade
            	Facade.setNames(toStringArray());
            	primaryStage.close();
            }
        });
        
        primaryStage.setOnCloseRequest(event -> {
		    System.out.println("Game Starting...");
		    Facade.setNames(toStringArray());
		});
        
        VBox format = new VBox();
        format.setAlignment(Pos.CENTER);;
        format.getChildren().addAll(root, plusMinus, startGame);
        root1.getChildren().addAll(format);

        primaryStage.setScene(scene1);
        primaryStage.showAndWait();
    }
    
    private String[] toStringArray() {
    	String[] s = new String[sequences.size()];
    	
    	for(int i = 0; i < sequences.size();i++) {
    		s[i] = combo.getItems().get(i).name.get();
    		System.out.println(s[i]);
    	}
    	
    	return s;
    }
}
