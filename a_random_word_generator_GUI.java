package a_random_word_generator;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.security.SecureRandom;
import java.util.ArrayList;


public class a_random_word_generator_GUI extends Application
{
	
	//VBox text_area_button                                          
		VBox text_area_button;
		Button launch;
		KeyValue yKeyValue;
		KeyValue xKeyValue;
		KeyFrame keyFrame;
		Timeline timeLine;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		
		
		// TODO Auto-generated method stub
		TextField nameTextField = new TextField();
		TextField messageTextField = new TextField();
		TextArea textArea = new TextArea();
		//textArea.setPrefSize(100, 100);

		BorderPane borderPane = new BorderPane();


		Text header = new Text("word generator");
		header.setFont(Font.font("arial",20));
		header.setStroke(Color.BLACK);
		
//				header.setTextAlignment(TextAlignment.CENTER);
//				header.setStyle("-fx-text-align:center;");
//				header.setUnderline(true);
		

		
		HBox hBox = new HBox(header);
		hBox.setStyle("-fx-background-color:coral");
		
		/**
		 * start to play animation as soon as the program starts
		 */
		animation(header);

		/**
		 * create a Text that will display the word
		 */
		Text text = new Text();
//		text.setStroke(Color.BLUEVIOLET);
		text.setFont(Font.font(40));


		FadeTransition ft = new FadeTransition(Duration.millis(2000), text);
	     ft.setFromValue(0.0);
	     ft.setToValue(1.0);
	     ft.setCycleCount(1);
	     ft.setAutoReverse(true);
		
		/**
		 * generate:Button
		 * 			clicked to generate the word
		 */

		Button generate = new Button("generate");
		generate.setPrefWidth(500);generate.setPrefHeight(100);

		generate.setStyle("-fx-background-color:darkcyan");
		generate.setFont(Font.font("serif",48));
		generate.setOnMouseEntered(e->{
			generate.setStyle("-fx-background-color:coral");
			//reset.setTextFill(Color.WHITE);
		});
		generate.setOnMouseExited(e->{
			generate.setStyle("-fx-background-color:darkcyan");
			//reset.setTextFill(Color.BLACK);
		});                                                                                                               
		generate.setOnAction(e ->
		{
			generateWord(text);                                                                               
		});




				borderPane.setTop(hBox);
				borderPane.setCenter(text);
				borderPane.setBottom(generate);
				borderPane.setPadding(new Insets(5));
		borderPane.setStyle("-fx-border-radius:10;-fx-border-color:coral;-fx-border-width:5");


		primaryStage.setScene(new Scene(borderPane,500,500));
		primaryStage.show();
		primaryStage.setResizable(false);
	}


	/**
	 * the method to generate the word
	 * @param text
	 */

	private void generateWord(Text text)
	{
		Character[]consonantChars = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};

		char[]vowelChars = {'a','e','i','o','u','y'};


		/**
		 * the length of the word chosen at random
		 */
		int consonants = 2 + new SecureRandom().nextInt(6);
		int vowels = 1 + new SecureRandom().nextInt(4);

		/**
		 * the arrayLists to hold the vowels and the consonants
		 */

		ArrayList<Character> consonantList = new ArrayList<>();
		ArrayList<Character>vowelList = new ArrayList<>();

		/**
		 * randomly select consontants and vowels into the respective arrayLists
		 * the number of the selected letters is dependent on the size of the
		 * <variable>consonants</variable> and <variable>vowels</variable>
		 */

		for(int i = 0; i < consonants;i++)
			consonantList.add(consonantChars[new SecureRandom().nextInt(20)]);

		for(int i = 0; i < vowels; i++)
			vowelList.add(vowelChars[new SecureRandom().nextInt(6)]);

		/**
		 * an arrayList to merge the <arrayList>consonantList</arrayList> and
		 * <arrayList>vowelList</arrayList> into one arrayList
		 */

		ArrayList<Character>merged = new ArrayList<>();
		merged.addAll(vowelList);
		merged.addAll(consonantList);

		/**
		 *  shuffle the content the <arrayList>merged</arrayList>
		 * content and put them in a new arrayList
		 */

		/*
		ArrayList<Character> shuffled = new ArrayList<>();
		shuffled.ensureCapacity(merged.size()); //set the size of <arrayList>shuffled</arrayList> as that of
		//<arrayList>merged></arrayList>
		*/

		char[	]shuffled = new char[merged.size()	];

		for(char each:merged)
		{
			int space = new SecureRandom().nextInt(merged.size());//the index of the <arrayList>shuffled
			//</arrayList> where a character is going to be put

			while(shuffled[space] != 0) space = new SecureRandom().nextInt(merged.size());

			//after an empty index is found , set its content to be the value contained in each
			shuffled[space	] = each;

		}

		/**
		 * print out the content of <arrayList>shuffled</arrayList>
		 */
		String finishedWord = "";//the final word displayed by the text
		for(char each:shuffled)
			finishedWord += each;

		/**
		 * set the text's word to finishedWord
		 */

		text.setText(finishedWord);

	}
	
	/**
	 * play animation for the header file
	 */
	
	//animation()
		void animation(Text header){
			
			
			// xKeyValue = new KeyValue(launch.layoutXProperty(),launch.getLayoutX());
			 yKeyValue = new KeyValue(header.translateXProperty(),350);
			
			 keyFrame = new KeyFrame(Duration.millis(3000),yKeyValue);
			
			 timeLine = new Timeline(keyFrame);
				timeLine.setCycleCount(2);
				timeLine.setAutoReverse(true);

			timeLine.setAutoReverse(true);
			timeLine.setCycleCount(Animation.INDEFINITE);

				timeLine.play();
				

				
				
		}

}
