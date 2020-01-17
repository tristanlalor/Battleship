package com.tlalor.battleship;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.*;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;

/* Awesome code
Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
double width = resolution.getWidth();
double height = resolution.getHeight();
double w = width/1280;  // your window width
double h = height/720;  // your window height
Scale scale = new Scale(w, h, 0, 0);
root.getTransforms().add(scale);
 */





public class BattleshipGUI extends Application {

    boolean MC = false;
    boolean W = false;
    Game game = null;
    HBox mainPane = new HBox();
    HBox idek = new HBox();
    VBox outerPane = new VBox();

    GridPane userBoard = new GridPane();
    GridPane computerBoard = new GridPane();
    HBox buttonPane = new HBox(10);
    public int count = 1;
    public int toggle = 1;
    public int toggle1 = 1;


    @Override
    public void start(Stage primaryStage) {

        try {
            game = new Game(1);
        } catch (IOException e) {
            e.printStackTrace();
            game = null;
        }

        primaryStage.setTitle("Battleship");

//########################################################################################################################
//                                                    Create Grids
//######################################################################################################################## 
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CellPane cp1 = new CellPane(game.getUserStatus(i, j),
                        i, j, true);
                cp1.setOnMouseClicked(this::addShipToUserLayout);
                userBoard.add(cp1, j, i);

            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                CellPane cp1 = new CellPane(game.getComputerStatus(i, j),
                        i, j, false);
                cp1.setStyle("-fx-background-color: white;");
                //cp1.setStyle("-fx-border-width: 5; -fx-border-color: black;");

                if (count >= 6) {
                    cp1.setOnMouseClicked(this::handleClick);
                    cp1.setOnMouseEntered(this::handleHover);
                    cp1.setOnMouseExited(this::handleExit);
                } else {
                    cp1.setOnMouseClicked(null);
                    cp1.setOnMouseEntered(null);
                    cp1.setOnMouseExited(null);
                }
//        cp1.setOnMouseClicked ( new EventHandler<MouseEvent>(){
//                 @Override
//          public void handle(MouseEvent event) {
//          // game2.makePlayerMove(x,y);
// //          cp1.setStyle("-fx-border-width: 5;" +
// //                     "-fx-border-color: black;");

// //          // grid.getChildren().clear();
// //          primaryStage.show();
//          this.handleClick(event);
//          
//          
//        }});
                computerBoard.add(cp1, j, i);

            }
        }
//########################################################################################################################
//                                                    Create Buttons
//########################################################################################################################
//HBox buttonPane = new HBox(10);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        createButtons();

// newGame = new Button("New Game");
// newGame.setOnAction( new EventHandler<ActionEvent>() {
// public void handle(ActionEvent e)
// {
// game = new TicTacToe();
// drawBoard();
// status.setText("");
// }
//  });


        this.instructions();

        Scene scene = new Scene(outerPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void instructions() {
        Text t2 = null;
        switch (count) {
            case 1: {
                t2 = new Text("Place your ships on the left side of the board. Left click to place across, right click to place vertical-down. Place your Aircraft Carrier (5).");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                t2.setTextAlignment(TextAlignment.CENTER);
                t2.setFill(Color.AZURE);
                break;
            }
            case 2: {
                t2 = new Text("Place your Battleship (4).");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                t2.setTextAlignment(TextAlignment.CENTER);
                t2.setFill(Color.AZURE);
                break;
            }
            case 3: {
                t2 = new Text("Place your Cruiser (3).");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                t2.setTextAlignment(TextAlignment.CENTER);
                t2.setFill(Color.AZURE);
                break;
            }
            case 4: {
                t2 = new Text("Place your Sub (3).");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                t2.setTextAlignment(TextAlignment.CENTER);
                t2.setFill(Color.AZURE);
                break;
            }
            case 5: {
                t2 = new Text("Place your Destroyer (2).");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                t2.setTextAlignment(TextAlignment.CENTER);
                t2.setFill(Color.AZURE);
                break;
            }
            default:
                t2 = new Text(" ");
                t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 16));
                break;
        }
        mainPane.getChildren().clear();
        outerPane.getChildren().clear();
        userBoard.setPrefSize(750, 750);
        computerBoard.setPrefSize(750, 750);
        mainPane.getChildren().add(userBoard);
        computerBoard.setStyle("-fx-background-color: black;" +
                "-fx-background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;");
        mainPane.getChildren().add(computerBoard);

        // //          cp1.setStyle("-fx-border-width: 5;" +
// //                     "-fx-border-color: black;");
        mainPane.setStyle("-fx-background-color: black;" +
                "-fx-border-width: 0;" +
                "-fx-background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-border-color: black;" +
                "-fx-background-size: 128 128;");
        //mainPane.setPrefSize(1500, 762);
        mainPane.setPrefSize(1660, 842);
        mainPane.setAlignment(Pos.CENTER);
        //"background-repeat: no-repeat;");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button secretHack = new Button(" ");
        secretHack.setPrefHeight(42);
        secretHack.setPrefWidth(42);
        secretHack.setStyle("-fx-background-color: transparent;" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;" +
                "-fx-text-fill: Azure;");
        secretHack.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                secretHack.setStyle("-fx-background-color:#dae7f3;");
            }
        });

        secretHack.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                secretHack.setStyle("-fx-background-color:transparent;");
            }
        });
        secretHack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e4) {
                toggle++;
                if (W){
                    toggle1++;
                    W = false;
                }
                if (toggle == 0)
                    MC = false;
                else if ((toggle % 2 == 0)) {
                    MC = true;
                    //W = false;
                    updateComputerBoard();
                    updateUserBoard();
                } else
                    MC = false;
                updateComputerBoard();
                updateUserBoard();
            }
        });
        Button weird = new Button();
        weird.setMaxHeight(7);
        weird.setMaxWidth(12);
        weird.setMinHeight(0);
        weird.setMinWidth(0);
        weird.setStyle("-fx-background-color: transparent;" +
                "-fx-font-size: 0;");
        weird.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                weird.setStyle("-fx-background-color:#AF5C5C;");
                        //"-fx-background-color:#dae7f3;");
            }
        });

        weird.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                weird.setStyle("-fx-background-color:transparent;");
            }
        });
        weird.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e5) {
                toggle1++;
                if (MC){
                    toggle++;
                    MC = false;
                }
                if (toggle1 == 0)
                    W = false;
                else if ((toggle1 % 2 == 0)) {
                    W = true;
                    //W = false;
                    updateComputerBoard();
                    updateUserBoard();
                } else
                    W = false;
                updateComputerBoard();
                updateUserBoard();
//                toggle1++;
//                if ((toggle1 % 2 == 0 ))
//                    W = true;
////                if (toggle == 1&&(toggle1%2==0))
////                    W = false;
////                else if ((toggle1 % 2 == 0 )) {
////                    W = true;
////                    toggle++;
////                    updateComputerBoard();
////                    updateUserBoard();}
//                 else
//                    W = false;
//                updateComputerBoard();
//                updateUserBoard();
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        StackPane tester = new StackPane();
        TextFlow textFlow = new TextFlow();
        textFlow.setLayoutX(40);
        textFlow.setLayoutY(40);
        Text t = new Text("Battleship");

        t.setFont(Font.font("Copperplate", FontWeight.BOLD, 52));
        t.setFill(Color.DIMGRAY);
        t.setTextAlignment(TextAlignment.CENTER);
        textFlow.getChildren().add(t);
        tester.getChildren().add(t);
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);
        pane.setMargin(weird, new Insets(0, 0, 6, 260));
        pane.setPrefSize(1660,0);
//        weird.setLayoutX(954);
//        weird.setLayoutY(20);
        pane.getChildren().add(weird);
        tester.getChildren().add(pane);
        outerPane.getChildren().add(tester);
        //outerPane.getChildren().add(t);
        outerPane.getChildren().add(t2);
        outerPane.getChildren().add(mainPane);
        buttonPane.setStyle("background-position: center center;" +
                "background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-border-color: black;");

        idek.getChildren().clear();
        Button placeHolder = new Button(" ");
        placeHolder.setStyle("-fx-background-color: transparent;" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;" +
                "-fx-text-fill: Azure;");
        idek.getChildren().add(placeHolder);
        idek.getChildren().add(buttonPane);
        buttonPane.setAlignment(Pos.CENTER);
        idek.getChildren().add(secretHack);
        idek.setAlignment(Pos.CENTER);
        idek.setSpacing(613);
        outerPane.getChildren().add(idek);
        outerPane.setAlignment(Pos.CENTER);
        outerPane.setStyle("background-position: center center;" +
                "-fx-background-image: url('tex3.png');" +
                "-fx-border-width: 0;" +
                "-fx-border-color: black;" +
                "-fx-background-size: 128 128;");
        //yournode.setStyle("-fx-background-color: #" + enteredByUser);
    }

    public void createButtons() {



        //buttonPane.getChildren.clear();
        Button compMove = new Button("Make Computer Move");
        compMove.setStyle("-fx-background-color: black;" +
                "-fx-background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;" +
                "-fx-text-fill: Azure;");
        compMove.setFont(Font.font("Copperplate", FontWeight.BOLD, 16));
        compMove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (count >= 6) {
                    String[] result = game.makeComputerMove();
                    Move move = new Move(result[0]);
                    updateUserBoard();
                    compMove.setOnAction(null);
                    if (result[1] != null) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setHeaderText("You spontaneously exclaim: \"" + result[1] + "\"");
                        alert.showAndWait();
                    }
                    if (game.computerDefeated() || game.userDefeated()) {
                        if (game.computerDefeated()) {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Game Over!\nYou defeated the Computer. That was easy.");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setHeaderText("Game Over!\nThe Computer wins!");
                            alert.showAndWait();
                        }
                    }
                }
            }
        });
        buttonPane.getChildren().add(compMove);
        //buttonPane.getChildren().add(secretHack);
        //buttonPane.getChildren().add(weird);
        Button exit = new Button("Exit");
        exit.setStyle("-fx-background-color: black;" +
                "-fx-background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;" +
                "-fx-text-fill: Azure;");
        exit.setFont(Font.font("Copperplate", FontWeight.BOLD, 16));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Platform.exit();
            }
        });

        Button newGame = new Button("New Game");
        newGame.setStyle("-fx-background-color: black;" +
                "-fx-background-image: url('tex2.png');" +
                "-fx-border-width: 0;" +
                "-fx-background-size: 128 128;" +
                "-fx-text-fill: Azure;");
        newGame.setFont(Font.font("Copperplate", FontWeight.BOLD, 16));
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    game = new Game(1);
                } catch (IOException f) {
                    f.printStackTrace();
                    game = null;
                }
                count = 1;
                buttonPane.getChildren().clear();
                createButtons();
                instructions();
                updateComputerBoard();
                updateUserBoard();
            }
        });
        buttonPane.getChildren().add(newGame);
        buttonPane.getChildren().add(exit);
        buttonPane.setPrefHeight(42);
        buttonPane.setAlignment(Pos.CENTER);
//updateUserBoard();
    }

    public void sendUserShiptoBoard(int shipLength, ShipType shipType) {

    }


    public void addShipToUserLayout(MouseEvent e) {
        ShipType ship = null;
        int length = 0;
        char charShip;
        boolean horizontal = true;
        if (e.getButton() == MouseButton.SECONDARY) {
            horizontal = false;
        }
        switch (count) {
            case 1: {
                ship = ShipType.ST_AIRCRAFT_CARRIER;
                break;
            }
            case 2: {
                ship = ShipType.ST_BATTLESHIP;
                break;
            }
            case 3: {
                ship = ShipType.ST_CRUISER;
                break;
            }
            case 4: {
                ship = ShipType.ST_SUB;
                break;
            }
            case 5: {
                ship = ShipType.ST_DESTROYER;
                break;
            }
            default:
                break;
        }

        switch (ship) {
            case ST_AIRCRAFT_CARRIER: {
                length = 5;
                break;
            }
            case ST_BATTLESHIP: {
                length = 4;
                break;
            }
            case ST_CRUISER: {
                length = 3;
                break;
            }
            case ST_DESTROYER: {
                length = 2;
                break;
            }
            case ST_SUB: {
                length = 3;
                break;
            }
            default:
                break;
        }


        if (!MC && !W) {
            CellPane cp = (CellPane) (e.getSource());
            int row = cp.row;
            int col = cp.col;
            boolean continueS = true;
            if (horizontal == true) {
                try {
                    for (int iteration = col; iteration < (col + length); iteration++) {
                        if (game.getUserStatus(row, iteration) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {
                    game.addShipToUserLayout(row, row, col, (col + length - 1), horizontal, ship);
                    //int idk1 = count;
                    for (int iteration = col; iteration < (col + length); iteration++) {

                        CellPane cp1 = new CellPane(game.getUserStatus(row, iteration),
                                row, iteration, true);
                        cp1.setOnMouseClicked(null);
                        //userBoard.add(cp2,j,i);
                        //int idk1 = col;

                        //CellPane cp2 = (CellPane)userBoard.getChildren().get(iteration*10+col-idk1);

                        //userBoard.getChildren().remove(cp2);
                        userBoard.add(cp1, iteration, row);
                        //idk1--;
                    }
                    count++;
                }
            }
            if (horizontal == false) {
                try {
                    for (int iteration = row; iteration < (row + length); iteration++) {
                        if (game.getUserStatus(iteration, col) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {

                    game.addShipToUserLayout(row, (row + length - 1), col, col, horizontal, ship);

                    if (horizontal == false) {
                        int idk1 = count;
                        for (int iteration = row; iteration < (row + length); iteration++) {

                            CellPane cp1 = new CellPane(game.getUserStatus(iteration, col),
                                    iteration, col, true);
                            cp1.setOnMouseClicked(null);
                            //userBoard.add(cp2,j,i);
                            //int idk1 = col;

                            //CellPane cp2 = (CellPane)userBoard.getChildren().get(iteration*10+col-idk1);

                            //userBoard.getChildren().remove(cp2);
                            userBoard.add(cp1, col, iteration);
                            idk1--;


                        }
                    }
                    count++;
                }
            }
            if (count >= 6)
                this.updateUserBoard();
            this.instructions();


        } else if (MC) {
            CellPaneMC cp = (CellPaneMC) (e.getSource());
            int row = cp.row;
            int col = cp.col;
            boolean continueS = true;
            if (horizontal == true) {
                try {
                    for (int iteration = col; iteration < (col + length); iteration++) {
                        if (game.getUserStatus(row, iteration) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {
                    game.addShipToUserLayout(row, row, col, (col + length - 1), horizontal, ship);
                    //int idk1 = count;
                    for (int iteration = col; iteration < (col + length); iteration++) {

                        CellPaneMC cp1 = new CellPaneMC(game.getUserStatus(row, iteration),
                                row, iteration, true);
                        cp1.setOnMouseClicked(null);
                        //userBoard.add(cp2,j,i);
                        //int idk1 = col;

                        //CellPane cp2 = (CellPane)userBoard.getChildren().get(iteration*10+col-idk1);

                        //userBoard.getChildren().remove(cp2);
                        userBoard.add(cp1, iteration, row);
                        //idk1--;
                    }
                    count++;
                }
            }
            if (horizontal == false) {
                try {
                    for (int iteration = row; iteration < (row + length); iteration++) {
                        if (game.getUserStatus(iteration, col) == CellStatus.NOTHING) {
                            continueS = true;
                        } else {
                            continueS = false;
                            break;
                        }

                    }
                } catch (IndexOutOfBoundsException e2) {
                    continueS = false;
                }
                if (continueS) {

                    game.addShipToUserLayout(row, (row + length - 1), col, col, horizontal, ship);

                    if (horizontal == false) {
                        int idk1 = count;
                        for (int iteration = row; iteration < (row + length); iteration++) {

                            CellPaneMC cp1 = new CellPaneMC(game.getUserStatus(iteration, col),
                                    iteration, col, true);
                            cp1.setOnMouseClicked(null);
                            userBoard.add(cp1, col, iteration);
                            idk1--;


                        }
                    }
                    count++;
                }
            }
            if (count >= 6)
                this.updateUserBoard();
            this.instructions();


        } else if (W) {
            {
                CellPaneW cp = (CellPaneW) (e.getSource());
                int row = cp.row;
                int col = cp.col;
                boolean continueS = true;
                if (horizontal == true) {
                    try {
                        for (int iteration = col; iteration < (col + length); iteration++) {
                            if (game.getUserStatus(row, iteration) == CellStatus.NOTHING) {
                                continueS = true;
                            } else {
                                continueS = false;
                                break;
                            }

                        }
                    } catch (IndexOutOfBoundsException e2) {
                        continueS = false;
                    }
                    if (continueS) {
                        game.addShipToUserLayout(row, row, col, (col + length - 1), horizontal, ship);
                        //int idk1 = count;
                        for (int iteration = col; iteration < (col + length); iteration++) {

                            CellPaneW cp1 = new CellPaneW(game.getUserStatus(row, iteration),
                                    row, iteration, true);
                            cp1.setOnMouseClicked(null);
                            //userBoard.add(cp2,j,i);
                            //int idk1 = col;

                            //CellPane cp2 = (CellPane)userBoard.getChildren().get(iteration*10+col-idk1);

                            //userBoard.getChildren().remove(cp2);
                            userBoard.add(cp1, iteration, row);
                            //idk1--;
                        }
                        count++;
                    }
                }
                if (horizontal == false) {
                    try {
                        for (int iteration = row; iteration < (row + length); iteration++) {
                            if (game.getUserStatus(iteration, col) == CellStatus.NOTHING) {
                                continueS = true;
                            } else {
                                continueS = false;
                                break;
                            }

                        }
                    } catch (IndexOutOfBoundsException e2) {
                        continueS = false;
                    }
                    if (continueS) {

                        game.addShipToUserLayout(row, (row + length - 1), col, col, horizontal, ship);

                        if (horizontal == false) {
                            int idk1 = count;
                            for (int iteration = row; iteration < (row + length); iteration++) {

                                CellPaneW cp1 = new CellPaneW(game.getUserStatus(iteration, col),
                                        iteration, col, true);
                                cp1.setOnMouseClicked(null);
                                userBoard.add(cp1, col, iteration);
                                idk1--;


                            }
                        }
                        count++;
                    }
                }
                if (count >= 6)
                    this.updateUserBoard();
                this.instructions();
            }
        }
    }


    public void handleClick(MouseEvent e) {
        if (!MC&&!W) {
            CellPane cp = (CellPane) (e.getSource());
            String sunk = game.makePlayerMove(cp.row, cp.col);
            this.updateComputerBoard();
            buttonPane.getChildren().clear();
            createButtons();
            if (sunk != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("The Computer says: \"" + sunk + "\"");
                alert.showAndWait();
            }
            if (game.computerDefeated() || game.userDefeated()) {
                if (game.computerDefeated()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nYou defeated the Computer. That was easy.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nThe Computer wins!");
                    alert.showAndWait();
                }
            }

            //cp.setStyle("-fx-border-width: 5; -fx-border-color: black;");

            CellPane cp1 = new CellPane(game.getComputerStatus(cp.row, cp.col),
                    cp.row, cp.col, false);
            cp1.setOnMouseClicked(null);
            cp1.setStyle("-fx-background-color: white;");
            computerBoard.getChildren().remove(cp);
            computerBoard.add(cp1, cp.col, cp.row);
        } else if (MC) {
            CellPaneMC cp = (CellPaneMC) (e.getSource());
            String sunk = game.makePlayerMove(cp.row, cp.col);
            this.updateComputerBoard();
            buttonPane.getChildren().clear();
            createButtons();
            if (sunk != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("The Computer says: \"" + sunk + "\"");
                alert.showAndWait();
            }
            if (game.computerDefeated() || game.userDefeated()) {
                if (game.computerDefeated()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nYou defeated the Computer. That was easy.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nThe Computer wins!");
                    alert.showAndWait();
                }
            }

            //cp.setStyle("-fx-border-width: 5; -fx-border-color: black;");

            CellPaneMC cp1 = new CellPaneMC(game.getComputerStatus(cp.row, cp.col),
                    cp.row, cp.col, false);
            cp1.setOnMouseClicked(null);
            cp1.setStyle("-fx-background-color: white;");
            computerBoard.getChildren().remove(cp);
            computerBoard.add(cp1, cp.col, cp.row);
        } else if (W) {
            CellPaneW cp = (CellPaneW) (e.getSource());
            String sunk = game.makePlayerMove(cp.row, cp.col);
            this.updateComputerBoard();
            buttonPane.getChildren().clear();
            createButtons();
            if (sunk != null) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("The Computer says: \"" + sunk + "\"");
                alert.showAndWait();
            }
            if (game.computerDefeated() || game.userDefeated()) {
                if (game.computerDefeated()) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nYou defeated the Computer. That was easy.");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText("Game Over!\nThe Computer wins!");
                    alert.showAndWait();
                }
            }

            //cp.setStyle("-fx-border-width: 5; -fx-border-color: black;");

            CellPaneW cp1 = new CellPaneW(game.getComputerStatus(cp.row, cp.col),
                    cp.row, cp.col, false);
            cp1.setOnMouseClicked(null);
            cp1.setStyle("-fx-background-color: white;");
            computerBoard.getChildren().remove(cp);
            computerBoard.add(cp1, cp.col, cp.row);
        }

        //this.drawBoard();

    }

    public void handleHover(MouseEvent e) {
        if (MC) {
            CellPaneMC cp = (CellPaneMC) (e.getSource());

            cp.setStyle("-fx-border-width: 1; -fx-border-color: red;");
        } else if (W) {
            CellPaneW cp = (CellPaneW) (e.getSource());

            cp.setStyle("-fx-border-width: 1; -fx-border-color: red;");
        } else {
            CellPane cp = (CellPane) (e.getSource());

            cp.setStyle("-fx-border-width: 1; -fx-border-color: red;");
        }

//    CellPane cp1 = new CellPane(game.getComputerStatus(cp.row,cp.col),
//        cp.row,cp.col, false);
//        cp1.setOnMouseClicked(null);
//        computerBoard.getChildren().remove(cp);
//     computerBoard.add(cp1,cp.col,cp.row);

        //this.drawBoard();

    }

    public void handleExit(MouseEvent e) {
        if (!MC&&!W) {
            CellPane cp = (CellPane) (e.getSource());

            cp.setStyle("-fx-border-width: 0; -fx-border-color: white;");
            cp.setStyle("-fx-background-color: white;");
        } else if (MC) {
            CellPaneMC cp = (CellPaneMC) (e.getSource());


            cp.setStyle("-fx-border-width: 0; -fx-border-color: white;");
            cp.setStyle("-fx-background-color: white;");
        } else if (W) {
            CellPaneW cp = (CellPaneW) (e.getSource());


            cp.setStyle("-fx-border-width: 0; -fx-border-color: white;");
            cp.setStyle("-fx-background-color: white;");
        }
    }



//    CellPane cp1 = new CellPane(game.getComputerStatus(cp.row,cp.col),
//        cp.row,cp.col, false);
//        cp1.setOnMouseClicked(null);
//        computerBoard.getChildren().remove(cp);
//     computerBoard.add(cp1,cp.col,cp.row);

        //this.drawBoard();


    public Node getNodeByRowColumnIndex(final int row, final int col, GridPane gridPane){
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for (Node node : childrens){
            if (gridPane.getRowIndex(node)==row&&gridPane.getColumnIndex(node) == col){
                result = node;
                break;
            }
        }
        return result;
    }

    public void updateUserBoard() {

        userBoard.getChildren().clear();
        computerBoard.getChildren().clear();
        if (!MC&&!W) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
//                CellPane cp2 = (CellPane)getNodeByRowColumnIndex(i,j,userBoard);
                    //CellPane cp2 = (CellPane)userBoard.getChildren().get(i*10+j);
                    CellPane cp2 = new CellPane(game.getUserStatus(i, j), i, j, true);
                    if (count < 6)
                        cp2.setOnMouseClicked(this::addShipToUserLayout);
                    else
                        cp2.setOnMouseClicked(null);

                    userBoard.add(cp2, j, i);

                    //CellPane cp1 = (CellPane)getNodeByRowColumnIndex(i,j,computerBoard);
                    //CellPane cp1 = (CellPane)computerBoard.getChildren().get(i*10+j);
                    CellPane cp1 = new CellPane(game.getComputerStatus(i, j), i, j, false);
                    //cp1.setStyle("-fx-border-width: 5; -fx-border-color: black;");
                    if (game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_SUNK || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_SUNK || game.getComputerStatus(i, j) == CellStatus.SUB_SUNK || game.getComputerStatus(i, j) == CellStatus.CRUISER_SUNK || game.getComputerStatus(i, j) == CellStatus.DESTROYER_SUNK || game.getComputerStatus(i, j) == CellStatus.NOTHING_HIT || game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_RIGHT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_LEFT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_H_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_H_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_H_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_H_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_BOTTOM_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_TOP_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_V_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_V_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_V_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_V_HIT) {

                        cp1.setOnMouseClicked(null);
                        cp1.setOnMouseEntered(null);
                        cp1.setOnMouseExited(null);

                    } else {
                        if (count >= 6) {
                            cp1.setOnMouseClicked(this::handleClick);
                            cp1.setOnMouseEntered(this::handleHover);
                            cp1.setOnMouseExited(this::handleExit);
                        } else {
                            cp1.setOnMouseClicked(null);
                            cp1.setOnMouseEntered(null);
                            cp1.setOnMouseExited(null);
                        }
                    }
                    cp1.setStyle("-fx-background-color: white;");
                    //instructions();
                    //computerBoard.clearConstraints(cp1);
                    //computerBoard.getChildren().remove(cp1);

                    computerBoard.add(cp1, j, i);
                    //computerBoard.setConstraints(cp1,j,i);
                    //computerBoard.getChildren().remove(i,j);
                    //computerBoard.add(cp1,i,j);


                }
            }
        } else if (MC)
            {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    CellPaneMC cp2 = new CellPaneMC(game.getUserStatus(i, j), i, j, true);
                    if (count < 6)
                        cp2.setOnMouseClicked(this::addShipToUserLayout);
                    else
                        cp2.setOnMouseClicked(null);
                    userBoard.add(cp2, j, i);
                    CellPaneMC cp1 = new CellPaneMC(game.getComputerStatus(i, j), i, j, false);
                    if (game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_SUNK || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_SUNK || game.getComputerStatus(i, j) == CellStatus.SUB_SUNK || game.getComputerStatus(i, j) == CellStatus.CRUISER_SUNK || game.getComputerStatus(i, j) == CellStatus.DESTROYER_SUNK || game.getComputerStatus(i, j) == CellStatus.NOTHING_HIT || game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_RIGHT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_LEFT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_H_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_H_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_H_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_H_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_BOTTOM_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_TOP_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_V_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_V_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_V_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_V_HIT) {
                        cp1.setOnMouseClicked(null);
                        cp1.setOnMouseEntered(null);
                        cp1.setOnMouseExited(null);
                    } else {
                        if (count >= 6) {
                            cp1.setOnMouseClicked(this::handleClick);
                            cp1.setOnMouseEntered(this::handleHover);
                            cp1.setOnMouseExited(this::handleExit);
                        } else {
                            cp1.setOnMouseClicked(null);
                            cp1.setOnMouseEntered(null);
                            cp1.setOnMouseExited(null);
                        }
                    }
                    cp1.setStyle("-fx-background-color: white;");
                    computerBoard.add(cp1, j, i);
                }

                //mainPane.getChildren().addAll(computerBoard);
            }
        }
        else if (W) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    CellPaneW cp2 = new CellPaneW(game.getUserStatus(i, j), i, j, true);
                    if (count < 6)
                        cp2.setOnMouseClicked(this::addShipToUserLayout);
                    else
                        cp2.setOnMouseClicked(null);
                    userBoard.add(cp2, j, i);
                    CellPaneW cp1 = new CellPaneW(game.getComputerStatus(i, j), i, j, false);
                    if (game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_SUNK || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_SUNK || game.getComputerStatus(i, j) == CellStatus.SUB_SUNK || game.getComputerStatus(i, j) == CellStatus.CRUISER_SUNK || game.getComputerStatus(i, j) == CellStatus.DESTROYER_SUNK || game.getComputerStatus(i, j) == CellStatus.NOTHING_HIT || game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_RIGHT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_RIGHT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_LEFT_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_LEFT_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_H_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_H_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_H_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_H_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_H_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_BOTTOM_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_BOTTOM_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_TOP_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_TOP_HIT ||
                            game.getComputerStatus(i, j) == CellStatus.AIRCRAFT_CARRIER_V_HIT || game.getComputerStatus(i, j) == CellStatus.BATTLESHIP_V_HIT || game.getComputerStatus(i, j) == CellStatus.SUB_V_HIT || game.getComputerStatus(i, j) == CellStatus.DESTROYER_V_HIT || game.getComputerStatus(i, j) == CellStatus.CRUISER_V_HIT) {
                        cp1.setOnMouseClicked(null);
                        cp1.setOnMouseEntered(null);
                        cp1.setOnMouseExited(null);
                    } else {
                        if (count >= 6) {
                            cp1.setOnMouseClicked(this::handleClick);
                            cp1.setOnMouseEntered(this::handleHover);
                            cp1.setOnMouseExited(this::handleExit);
                        } else {
                            cp1.setOnMouseClicked(null);
                            cp1.setOnMouseEntered(null);
                            cp1.setOnMouseExited(null);
                        }
                    }
                    cp1.setStyle("-fx-background-color: white;");
                    computerBoard.add(cp1, j, i);
                }

                //mainPane.getChildren().addAll(computerBoard);
            }
        }
    }

    public void updateComputerBoard()
    {
        computerBoard.getChildren().clear();
        // mainPane.getChildren().add(userBoard);
//  mainPane.getChildren().add(computerBoard);
        if (!MC&&!W){
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++) {
                    //CellPane cp2 = (CellPane)computerBoard.getChildren().get(j*10+i);
                    CellPane cp1 = new CellPane(game.getComputerStatus(i, j),
                            i, j, false);
                    cp1.setOnMouseClicked(null);
                    cp1.setOnMouseEntered(null);
                    cp1.setOnMouseExited(null);

                    cp1.setStyle("-fx-background-color: white;");
                    //computerBoard.getChildren().remove(cp2);
                    computerBoard.add(cp1, j, i);
                }
            }
        }
        else if (MC){
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //CellPane cp2 = (CellPane)computerBoard.getChildren().get(j*10+i);
                    CellPaneMC cp1 = new CellPaneMC(game.getComputerStatus(i, j),
                            i, j, false);
                    cp1.setOnMouseClicked(null);
                    cp1.setOnMouseEntered(null);
                    cp1.setOnMouseExited(null);

                    cp1.setStyle("-fx-background-color: white;");
                    //computerBoard.getChildren().remove(cp2);
                    computerBoard.add(cp1, j, i);
                }
            }
        }
        else if (W){
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    //CellPane cp2 = (CellPane)computerBoard.getChildren().get(j*10+i);
                    CellPaneW cp1 = new CellPaneW(game.getComputerStatus(i, j),
                            i, j, false);
                    cp1.setOnMouseClicked(null);
                    cp1.setOnMouseEntered(null);
                    cp1.setOnMouseExited(null);

                    cp1.setStyle("-fx-background-color: white;");
                    //computerBoard.getChildren().remove(cp2);
                    computerBoard.add(cp1, j, i);
                }
            }
        }


    }




//            convert waterMCfull.gif -layers Coalesce -resize 16x16 -layers Optimize j.gif
//            convert waterMCfull.gif -layers Coalesce -resample 256 -layers Optimize k.gif
//convert waterMCfull.gif -resize 16x16 k.gif
//convert waterMC.gif -resample 256 k.gif
//    mogrify -normalize -resize 16x16 good.gif -sharpen 0x.4
//convert water_copy.gif -layers Coalesce -resize 8x8 -layers Optimize k.gif
    //convert waterMC.gif -layers Coalesce -resize 16x16 -layers Optimize h.gif
//convert computerNothingMC.gif -layers Coalesce -resize 16x16 -layers Optimize b.gif
    //magick -dispose previous -delay 10 waterMCfull.gif -trim -layers TrimBounds -resize 16x16 -layers optimize -loop 0 output4.gif
//convert waterMCfull.gif -layers Coalesce -scale 16x16 -layers Optimize j.gif
//convert waterMC1.gif -layers Optimize j.gif

//    mogrify -layers 'optimize' -fuzz 7% computerNothingMC1.gif

    //mogrify -quality 80% computerNothingMC2.gif j.gif
//    convert computerNothingMC1.gif -layers Coalesce -resize 16x16 -layers Optimize -loop 0 j.gif
//
//    convert computerNothingMC.gif -loop 0 computerNothingMC.gif
    //convert waterMC.gif -loop 0 waterMC.gif
    //convert userSunkMC.gif -loop 0 userSunkMC.gif
    /*
    convert waterMC.gif -layers Coalesce -resize 16x16 -layers Optimize -loop 0 j.gif
    convert j.gif -layers Coalesce -resize 16x16 -layers Optimize -loop 0 j.gif
    convert j.gif -layers Coalesce -resize 8x8 -layers Optimize -loop 0 j.gif
    convert waterMC.gif -layers Coalesce -resize 4x4 -layers Optimize -loop 0 waterMC.gif
    convert computerNothingMC.gif -layers Coalesce -resize 4x4 -layers Optimize -loop 0 computerNothingMC.gif

-colors 255
convert left.png -layers Coalesce -resize 128x128 -layers Optimize -colors 255 left1.png
convert right.png -layers Coalesce -resize 128x128 -layers Optimize -colors 255 right1.png
convert h.png -layers Coalesce -resize 128x128 -layers Optimize -colors 255 h1.png

convert leftMC0.png -layers Coalesce -geometry x128 -layers Optimize -colors 255 leftMC.png
convert rightMC0.png -layers Coalesce -geometry x128 -layers Optimize rightMC.png
convert hMC0.png -layers Coalesce -geometry x128 -layers Optimize -colors 255 hMC.png

convert bottom.png -layers Coalesce -geometry x128 -colors 255 bottom.png
convert bottomMC.png -layers Coalesce -geometry x128 -colors 255 bottomMC.png
convert bottomW.png -layers Coalesce -geometry x128 -colors 255 bottomW.png
convert top.png -layers Coalesce -geometry x128 -colors 255 top.png
convert topMC.png -layers Coalesce -geometry x128 -colors 255 topMC.png
convert topW.png -layers Coalesce -geometry x128 -colors 255 topW.png
convert v.png -layers Coalesce -geometry x128 -colors 255 v.png
convert vMC.png -layers Coalesce -geometry x128 -colors 255 vMC.png
convert vW.png -layers Coalesce -geometry x128 -colors 255 vW.png

convert small.png -layers Coalesce -geometry x128 -colors 255 small.png
convert smallMC.png -layers Coalesce -geometry x128 -colors 255 smallMC.png
convert smallW.png -layers Coalesce -geometry x128 -colors 255 smallW.png

convert h.png -layers Coalesce -geometry 128x -colors 255 h.png
convert hMC.png -layers Coalesce -geometry 128x -colors 255 hMC.png
convert hW.png -layers Coalesce -geometry 128x -colors 255 hW.png
convert left.png -layers Coalesce -geometry 128x -colors 255 left.png
convert leftMC.png -layers Coalesce -geometry 128x -colors 255 leftMC.png
convert leftW.png -layers Coalesce -geometry 128x -colors 255 leftW.png
convert right.png -layers Coalesce -geometry 128x -colors 255 right.png
convert rightMC.png -layers Coalesce -geometry 128x -colors 255 rightMC.png
convert rightW.png -layers Coalesce -geometry 128x -colors 255 rightW.png






     */






// 










//     public void handleClick(MouseEvent e)
//    {  
//         game.makePlayerMove(x,y);
//          cp1.setStyle("-fx-border-width: 5;" +
//                     "-fx-border-color: black;");
//          // grid.getChildren().clear();
//          primaryStage.show();
    //  drawBoard();
//          if (game.gameOver())
//          {
//             for (Node pane: grid.getChildren())
//                pane.setOnMouseClicked(null);
// 
//             char ch = game.winner();
//             if (ch == 'x')
//                status.setText("X wins");
//             
//             else if (ch == 'o')
//                status.setText("O wins");
//             else
//                status.setText("It's a draw");
//             
// //          }
//       }
//          
//       
//    } 



    public static void main(String [] args) {

        launch(args);
    }
}