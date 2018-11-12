package application;

import java.util.ArrayList;

import TicketToRide.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;


public class Main extends Application implements EventHandler<ActionEvent> {
	public static Board b = new Board();
	static Move m = new Move();
	public static Player p1;
	public static Player p2;
	public static Player activePlayer;
	static Button[] trackButtons = new Button[45];
	static Button[] faceUpButtons = new Button[5];
	static Rectangle[] cardHand = new Rectangle[10];
	String[] options = new String[] {"CLAIM TRACKS", "TRAIN CARDS", "DEST. CARDS"};
	static Button[] moveButtons = new Button[3];
	static Button trainDeckButton;
	static Text playerInfo;
	static Text instructions;	//instruction text
	static int count; //helps count the numbe of cards fetched
	public static Pane cardLayout; //holds all the cards 
	Stage window;	//main stage

	
	@Override
	public void start(Stage primaryStage) {	
		window = primaryStage;
		VBox boardLayout = new VBox();
		Pane playerLayout = playerLayout();
		boardLayout.setSpacing(5);
		VBox trackLayout = tracksLayout();
		Pane cardLayout = cardLayout();
		Separator s1 = new Separator();
		Separator s2 = new Separator();
		s1.setMinWidth(1100);
		s2.setMinWidth(1100);
		boardLayout.getChildren().addAll(playerLayout,s1, trackLayout, s2, cardLayout);

		Scene scene = new Scene(boardLayout, 1120, 1400);
		
		window.setScene(scene);
		window.setTitle("Heptalion");
		window.show();	
	}
	
	//layout for player view on top left
	public Pane playerLayout() {
		Pane playerLayout = new Pane();
		playerInfo = new Text (10, 20, "CURRENT PLAYER: "+ activePlayer.getName() +"\nCURRENT SCORE: " + activePlayer.getScore().getValue());
		playerInfo.setFont(Font.font ("Verdana", 16));
		Button quit = new Button("QUIT GAME");
		quit.setLayoutX(1010);
		quit.setLayoutY(10);
		quit.setId("quit");
		quit.setOnAction(this);
		playerLayout.getChildren().addAll(playerInfo, quit);
		return playerLayout;
	}
	
	//layout for all the cards in the board
	public Pane cardLayout() {
		cardLayout = new Pane(); //initialize the container
		
		
		//Players hand
		Text text = new Text (160, 20, "YOUR HAND");
		text.setFont(Font.font ("Verdana", 20));
		cardLayout.getChildren().add(text);
		//starting position of the buttons
		double x = 10;
		double y = 30;		
		
		//set placeholder for player card hands
		for(int i = 0; i < cardHand.length; i++) {			
			cardHand[i] = new Rectangle(x, y, 70, 100);
			cardHand[i].setFill(Color.WHITE);
			x += 85;
			if((i + 1) % 5 == 0) {
				x = 10;
				y += 105;
			}
			cardLayout.getChildren().add(cardHand[i]);
		}
		
		setHandView(activePlayer); // show colors of the cards in hand
		
		
		//Options to make one of the move
		Text text3 = new Text (460, 20, "MAKE MOVE");
		text3.setFont(Font.font ("Verdana", 20));
		cardLayout.getChildren().add(text3);
		
		//starting position of the buttons
		double x1 = 460;
		double y1 = 30;		
		for(int i = 0; i < moveButtons.length; i++) {
			moveButtons[i]= new Button(options[i]);
			moveButtons[i].setLayoutX(x1);
			moveButtons[i].setLayoutY(y1);	
			moveButtons[i].setMinWidth(110);
			moveButtons[i].setMaxHeight(30);
			moveButtons[i].setId("move");
			moveButtons[i].setOnAction(this);
			moveButtons[i].setAlignment(Pos.BASELINE_CENTER);
			y1 += 40;
			cardLayout.getChildren().add(moveButtons[i]);
		}

		//Train deck
		Text trainDeckText = new Text (600, 20, "T-DECK");
		trainDeckText.setFont(Font.font ("Verdana", 20));
		cardLayout.getChildren().add(trainDeckText);
		

		trainDeckButton = new Button();
		trainDeckButton.setLayoutX(600);
		trainDeckButton.setLayoutY(30);
		trainDeckButton.setMinWidth(70);
		trainDeckButton.setMinHeight(100);
		trainDeckButton.setId("cards");
		trainDeckButton.setOnAction(this);
		trainDeckButton.setDisable(true);
		trainDeckButton.setAlignment(Pos.BASELINE_CENTER);
		trainDeckButton.setStyle("-fx-background-color: BLACK;");
		cardLayout.getChildren().add(trainDeckButton);

		
		//Face up cards
		Text text1 = new Text (850, 20, "FACE UP CARDS");
		text1.setFont(Font.font ("Verdana", 20));
		cardLayout.getChildren().add(text1);
		//starting position of the buttons
		double x2 = 720;
		double y2 = 30;		
		Card[] faceupCards = b.getFaceupCards();	
		for(int i = 0; i < faceUpButtons.length; i++) {
			faceUpButtons[i]= new Button("");
			faceUpButtons[i].setLayoutX(x2);
			faceUpButtons[i].setLayoutY(y2);	
			faceUpButtons[i].setMinWidth(70);
			faceUpButtons[i].setDisable(true);
			faceUpButtons[i].setMinHeight(100);
			faceUpButtons[i].setId("cards");
			faceUpButtons[i].setOnAction(this);
			faceUpButtons[i].setStyle("-fx-background-color: " + faceupCards[i].getName() +";");
			faceUpButtons[i].setAlignment(Pos.BASELINE_CENTER);
			 x2 += 80;
			cardLayout.getChildren().add(faceUpButtons[i]);
		}
		
		
		
		//Instruction
		Text instruction = new Text (510, 200, "INSTRUCTIONS");
		instruction.setFont(Font.font ("Verdana", 20));
		cardLayout.getChildren().add(instruction);
		instructions = new Text (510, 220, "Please choose one of the move.");
		instructions.setFont(Font.font ("Verdana", 16));
		cardLayout.getChildren().add(instructions);
		
		return cardLayout;
	}

	//layout is set for player
	public VBox tracksLayout() {
	
		VBox outerContainer = new VBox();
		StackPane row1 = new StackPane();
		StackPane row2 = new StackPane();
		Pane buttonPlaceholder = new Pane();
		
		Text text = new Text (10, 20, "CITIES AND TRAIN TRACK");
		text.setFont(Font.font ("Verdana", 20));
	      
		
		//starting position of the buttons
		int initX = 10;
		int initY = 10;
	
		
		//loop through each button and setup
		for(int i = 0; i < trackButtons.length; i++) {		
			trackButtons[i]= new Button(b.getTracks()[i].toString());
			trackButtons[i].setLayoutX(initX);
			trackButtons[i].setLayoutY(initY);	
			trackButtons[i].setDisable(true);
			trackButtons[i].setId("track");
			trackButtons[i].setOnAction(this);
			trackButtons[i].setMinWidth(210);
			trackButtons[i].setAlignment(Pos.BASELINE_CENTER);
			 if(b.getTracks()[i].getClaimStatus())
				 trackButtons[i].setStyle("-fx-background-color: red;");
			 initX += 220;
			 buttonPlaceholder.getChildren().add(trackButtons[i]);
			 //if three buttons are in a row move to next row
			 if((i+1) % 5 == 0) {
				 initY += 40;
				 initX = 10; 
			 }		 
		}

		row1.getChildren().add(text);
		row2.getChildren().add(buttonPlaceholder);
		outerContainer.getChildren().addAll(row1, row2);
		
		return outerContainer;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button buttonClicked = (Button) event.getSource();
		
		switch(buttonClicked.getId()) {
		case "track":
			System.out.println("track");		
			handleClaimView(buttonClicked, indexOf(trackButtons, buttonClicked));
			break;
		case "move":
			switch(indexOf(moveButtons, buttonClicked))  {
			case 0:
				System.out.println("Claim a city");
				instructions.setText("Please click on the city you want to claim");
				enableButtons(trackButtons);
				disableButtons(moveButtons);
				
				break;
			case 1:
				System.out.println("Fetch Train cards");
				instructions.setText("You may pick two train cards from either faceup cards or train deck.");
				count = 0;
				trainDeckButton.setDisable(false);
				enableButtons(faceUpButtons);
				disableButtons(trackButtons);
				disableButtons(moveButtons);
				
				
				break;
			case 2:
				System.out.println("Fetch destination cards");
				break;
			default:
				
			}
			
			break;
		case "cards":
			handleTrainFetchView(buttonClicked);
		break;
		default:
			System.out.println("quitting now");
			Player winner = m.findWinner(p1, p2);
			Pane winnerView = new Pane();
			Text winnerInfo = new Text(500, 400, "");
			if (winner != null) {
				winnerInfo.setText("THE WINNER IS\n        " + winner.getName() + "\n     SCORE: " + winner.getScore().getValue());
			}
			else winnerInfo.setText("IT WAS A DRAW");
			winnerInfo.setFont(Font.font ("Verdana", 24));
			winnerView.getChildren().add(winnerInfo);
			Scene scene2 = new Scene(winnerView, 1120, 1400);
			window.setScene(scene2);
		}
		
	}
	
	//kicks in when player wants to get more train cards
	public static void handleTrainFetchView(Button btn) {
		if(b.getTopTrainCardIndex() >= 18) {
			b.setTopTrainCardIndex(0);
			b.shuffleCard();
		}
			
		System.out.println(b.getTopTrainCardIndex());
		//dont move train deck
		if(btn.getLayoutX() <= 600.00){
			System.out.println("TRAIN DECK");
			m.fetchTrainCards(b, activePlayer, "DECK", b.getTopTrainCardIndex());	
			setHandView(activePlayer);
		}
		else {
			int index = indexOf(faceUpButtons, btn);
			System.out.println(b.getFaceupCards()[index].getName());
			m.fetchTrainCards(b, activePlayer, "FACEUP", index);
			faceUpButtons[index].setStyle("-fx-background-color: " + b.getFaceupCards()[index].getName() +";");
			System.out.println(b.getFaceupCards()[index].getName());
			setHandView(activePlayer);
			//cardLayout.getChildren().remove(faceUpButtons[index]);
		}
		
		count++;
		if(count == 2) {		
			enableButtons(moveButtons);
			disableButtons(faceUpButtons);
			trainDeckButton.setDisable(true);
			switchPlayerTurn();
		}
		
	}
	
	//kicks in when player wants to claim a city
	public static void handleClaimView(Button btn, int index) {

		boolean tryClaiming = m.claimCity(b, activePlayer, index);
		if(tryClaiming) {		
			btn.setStyle("-fx-background-color: RED;");	
			switchPlayerTurn();
			disableButtons(trackButtons);
			enableButtons(moveButtons);
		}
		else {
			instructions.setText("City Could not be claimed, chose another move or another city");
		}

	}
	
	//sets of color of the given rectangle
	public static void setupColor(Rectangle rect, String name) {
		switch(name) {
		case "RED":
			rect.setFill(Color.RED);
			break;
		case "GREEN":
			rect.setFill(Color.GREEN);
			break;
		case "BLUE":
			rect.setFill(Color.BLUE);
			break;
		case "YELLOW":
			rect.setFill(Color.YELLOW);
			break;
		default:
			rect.setFill(Color.BLACK);	
		}
	}
	
	//updates and sets the player hand cards
	public static void setHandView(Player _activePlayer) {
		ArrayList <Card> hand = _activePlayer.getTrainCards();
		for(int i = 0; i < cardHand.length; i++) {	
			cardHand[i].setFill(Color.WHITE);
		}
		for(int i = 0; i < hand.size(); i++) {	
			setupColor(cardHand[i], hand.get(i).getName());
		}
	}
	
	//disables the provided array of buttons
	public static void disableButtons(Button[] buttons) {
		for(Button b:buttons) {
			b.setDisable(true);
		}	
	}
	
	//enables the provided array of buttons
	public static void enableButtons(Button[] buttons) {
		for(Button b:buttons) {
			b.setDisable(false);
		}	
	}
	
	// Function to find the index of an element in a primitive array in Java
	public static int indexOf(Button[] a, Button target){
		for (int i = 0; i < a.length; i++)
			if (a[i] == target)
				return i;

		return -1;
	}
	
	//initializes the players
	public static void setupPlayers() {		
		p1 = new Player("Safal", b.fetchCard("TRAIN" ,4), b.fetchCard("DESTINATION", 3));
		p2 = new Player("Aastha", b.fetchCard("TRAIN" ,4), b.fetchCard("DESTINATION", 3));
	}
	
	//switches the active player and turn
	public static void switchPlayerTurn(){
		p1.switchTurn();
		p2.switchTurn();
		activePlayer = p1.hasTurn() ? p1 : p2;
		playerInfo.setText("CURRENT PLAYER: "+ activePlayer.getName() +"\nCURRENT SCORE: " + activePlayer.getScore().getValue());
		setHandView(activePlayer);	
	}
	
	//sets up the board
	public static void setupBoard() {
		b.shuffleCard();
		setupPlayers();
		b.turnFaceUpCard();
		p1.switchTurn();
		activePlayer = p1.hasTurn() ? p1 : p2;
	}
	
	//Launcher 
	public static void main(String[] args) {	
		setupBoard();
		launch(args);
	}
		
}
