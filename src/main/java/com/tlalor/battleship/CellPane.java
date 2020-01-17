package com.tlalor.battleship;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class CellPane extends HBox
{


   public int row;

   public int col;
   private CellStatus cellStatus;
   private boolean userBoard;
   public CellPane(){}
   public CellPane(CellStatus cellStatus, int row, int col, boolean userBoard)
   {
      this.row = row;
      this.col = col;

      if (userBoard)
      {
         if (cellStatus == CellStatus.NOTHING)
         {
            this.userNothing();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_HIT || cellStatus == CellStatus.BATTLESHIP_HIT || cellStatus == CellStatus.SUB_HIT || cellStatus == CellStatus.DESTROYER_HIT || cellStatus == CellStatus.CRUISER_HIT)
         {
            this.userHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER || cellStatus == CellStatus.BATTLESHIP || cellStatus == CellStatus.SUB || cellStatus == CellStatus.DESTROYER || cellStatus == CellStatus.CRUISER)
         {
            this.userShip();
         }
         else if (cellStatus == CellStatus.NOTHING_HIT)
         {
            this.userNothingHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_V || cellStatus == CellStatus.BATTLESHIP_V || cellStatus == CellStatus.SUB_V || cellStatus == CellStatus.DESTROYER_V || cellStatus == CellStatus.CRUISER_V)
         {
            this.userV();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_V_HIT || cellStatus == CellStatus.BATTLESHIP_V_HIT || cellStatus == CellStatus.SUB_V_HIT || cellStatus == CellStatus.DESTROYER_V_HIT || cellStatus == CellStatus.CRUISER_V_HIT)
         {
            this.userVHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_TOP || cellStatus == CellStatus.BATTLESHIP_TOP || cellStatus == CellStatus.SUB_TOP || cellStatus == CellStatus.DESTROYER_TOP || cellStatus == CellStatus.CRUISER_TOP)
         {
            this.userTop();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || cellStatus == CellStatus.BATTLESHIP_TOP_HIT || cellStatus == CellStatus.SUB_TOP_HIT || cellStatus == CellStatus.DESTROYER_TOP_HIT || cellStatus == CellStatus.CRUISER_TOP_HIT)
         {
            this.userTopHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM || cellStatus == CellStatus.BATTLESHIP_BOTTOM || cellStatus == CellStatus.SUB_BOTTOM || cellStatus == CellStatus.DESTROYER_BOTTOM || cellStatus == CellStatus.CRUISER_BOTTOM)
         {
            this.userBottom();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || cellStatus == CellStatus.BATTLESHIP_BOTTOM_HIT || cellStatus == CellStatus.SUB_BOTTOM_HIT || cellStatus == CellStatus.DESTROYER_BOTTOM_HIT || cellStatus == CellStatus.CRUISER_BOTTOM_HIT)
         {
            this.userBottomHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_H || cellStatus == CellStatus.BATTLESHIP_H || cellStatus == CellStatus.SUB_H || cellStatus == CellStatus.DESTROYER_H || cellStatus == CellStatus.CRUISER_H)
         {
            this.userH();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_H_HIT || cellStatus == CellStatus.BATTLESHIP_H_HIT || cellStatus == CellStatus.SUB_H_HIT || cellStatus == CellStatus.DESTROYER_H_HIT || cellStatus == CellStatus.CRUISER_H_HIT)
         {
            this.userHHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_LEFT || cellStatus == CellStatus.BATTLESHIP_LEFT || cellStatus == CellStatus.SUB_LEFT || cellStatus == CellStatus.DESTROYER_LEFT || cellStatus == CellStatus.CRUISER_LEFT)
         {
            this.userLeft();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || cellStatus == CellStatus.BATTLESHIP_LEFT_HIT || cellStatus == CellStatus.SUB_LEFT_HIT || cellStatus == CellStatus.DESTROYER_LEFT_HIT || cellStatus == CellStatus.CRUISER_LEFT_HIT)
         {
            this.userLeftHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT || cellStatus == CellStatus.BATTLESHIP_RIGHT || cellStatus == CellStatus.SUB_RIGHT || cellStatus == CellStatus.DESTROYER_RIGHT || cellStatus == CellStatus.CRUISER_RIGHT)
         {
            this.userRight();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || cellStatus == CellStatus.BATTLESHIP_RIGHT_HIT || cellStatus == CellStatus.SUB_RIGHT_HIT || cellStatus == CellStatus.DESTROYER_RIGHT_HIT || cellStatus == CellStatus.CRUISER_RIGHT_HIT)
         {
            this.userRightHit();
         }

         else
            this.userSunk();
      }
//######################################################################################################################################################################################
      else
      {

         if (cellStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT_HIT || cellStatus == CellStatus.BATTLESHIP_RIGHT_HIT || cellStatus == CellStatus.SUB_RIGHT_HIT || cellStatus == CellStatus.DESTROYER_RIGHT_HIT || cellStatus == CellStatus.CRUISER_RIGHT_HIT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_LEFT_HIT || cellStatus == CellStatus.BATTLESHIP_LEFT_HIT || cellStatus == CellStatus.SUB_LEFT_HIT || cellStatus == CellStatus.DESTROYER_LEFT_HIT || cellStatus == CellStatus.CRUISER_LEFT_HIT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_H_HIT || cellStatus == CellStatus.BATTLESHIP_H_HIT || cellStatus == CellStatus.SUB_H_HIT || cellStatus == CellStatus.DESTROYER_H_HIT || cellStatus == CellStatus.CRUISER_H_HIT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM_HIT || cellStatus == CellStatus.BATTLESHIP_BOTTOM_HIT || cellStatus == CellStatus.SUB_BOTTOM_HIT || cellStatus == CellStatus.DESTROYER_BOTTOM_HIT || cellStatus == CellStatus.CRUISER_BOTTOM_HIT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_TOP_HIT || cellStatus == CellStatus.BATTLESHIP_TOP_HIT || cellStatus == CellStatus.SUB_TOP_HIT || cellStatus == CellStatus.DESTROYER_TOP_HIT || cellStatus == CellStatus.CRUISER_TOP_HIT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_V_HIT || cellStatus == CellStatus.BATTLESHIP_V_HIT || cellStatus == CellStatus.SUB_V_HIT || cellStatus == CellStatus.DESTROYER_V_HIT || cellStatus == CellStatus.CRUISER_V_HIT)
         {
            this.computerHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT || cellStatus == CellStatus.BATTLESHIP_RIGHT || cellStatus == CellStatus.SUB_RIGHT || cellStatus == CellStatus.DESTROYER_RIGHT || cellStatus == CellStatus.CRUISER_RIGHT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_LEFT || cellStatus == CellStatus.BATTLESHIP_LEFT || cellStatus == CellStatus.SUB_LEFT || cellStatus == CellStatus.DESTROYER_LEFT || cellStatus == CellStatus.CRUISER_LEFT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_H || cellStatus == CellStatus.BATTLESHIP_H || cellStatus == CellStatus.SUB_H || cellStatus == CellStatus.DESTROYER_H || cellStatus == CellStatus.CRUISER_H ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM || cellStatus == CellStatus.BATTLESHIP_BOTTOM || cellStatus == CellStatus.SUB_BOTTOM || cellStatus == CellStatus.DESTROYER_BOTTOM || cellStatus == CellStatus.CRUISER_BOTTOM ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_TOP || cellStatus == CellStatus.BATTLESHIP_TOP || cellStatus == CellStatus.SUB_TOP || cellStatus == CellStatus.DESTROYER_TOP || cellStatus == CellStatus.CRUISER_TOP ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_V || cellStatus == CellStatus.BATTLESHIP_V || cellStatus == CellStatus.SUB_V || cellStatus == CellStatus.DESTROYER_V || cellStatus == CellStatus.CRUISER_V)
         {
            this.computerShip();
         }

         else if (cellStatus == CellStatus.NOTHING)
         {
            this.computerNothing();
         }

         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_HIT || cellStatus == CellStatus.BATTLESHIP_HIT || cellStatus == CellStatus.SUB_HIT || cellStatus == CellStatus.DESTROYER_HIT || cellStatus == CellStatus.CRUISER_HIT)
         {
            this.computerHit();
         }
         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER || cellStatus == CellStatus.BATTLESHIP || cellStatus == CellStatus.SUB || cellStatus == CellStatus.DESTROYER || cellStatus == CellStatus.CRUISER)
         {
            this.computerShip();
         }
         else if (cellStatus == CellStatus.NOTHING_HIT)
         {
            this.computerNothingHit();
         }


         else if (cellStatus == CellStatus.AIRCRAFT_CARRIER_V || cellStatus == CellStatus.BATTLESHIP_V || cellStatus == CellStatus.SUB_V || cellStatus == CellStatus.DESTROYER_V || cellStatus == CellStatus.CRUISER_V || cellStatus == CellStatus.AIRCRAFT_CARRIER_TOP || cellStatus == CellStatus.BATTLESHIP_TOP || cellStatus == CellStatus.SUB_TOP || cellStatus == CellStatus.DESTROYER_TOP || cellStatus == CellStatus.CRUISER_TOP ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_BOTTOM || cellStatus == CellStatus.BATTLESHIP_BOTTOM || cellStatus == CellStatus.SUB_BOTTOM || cellStatus == CellStatus.DESTROYER_BOTTOM || cellStatus == CellStatus.CRUISER_BOTTOM ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_H || cellStatus == CellStatus.BATTLESHIP_H || cellStatus == CellStatus.SUB_H || cellStatus == CellStatus.DESTROYER_H || cellStatus == CellStatus.CRUISER_H ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_LEFT || cellStatus == CellStatus.BATTLESHIP_LEFT || cellStatus == CellStatus.SUB_LEFT || cellStatus == CellStatus.DESTROYER_LEFT || cellStatus == CellStatus.CRUISER_LEFT ||
                 cellStatus == CellStatus.AIRCRAFT_CARRIER_RIGHT || cellStatus == CellStatus.BATTLESHIP_RIGHT || cellStatus == CellStatus.SUB_RIGHT || cellStatus == CellStatus.DESTROYER_RIGHT || cellStatus == CellStatus.CRUISER_RIGHT)
         {
            this.computerNothing();
         }
         else
            this.computerSunk();


      }



   }
   //   public CellPane(int numCircles, Color c)
//    {
//     this.setAlignment(Pos.CENTER);
//     this.setPrefSize(83,83);
//     this.setStyle("-fx-border-width: 5;" +
//                   "-fx-border-color: black;");
//     for (int i = 0; i < numCircles; i++)
//        this.getChildren().add(new Circle(10,c));
//     fill = c;
//     this.numCircles = numCircles;
//    
//    
//    
//    }
//    public Color getFill()
//    {
//       return fill;
//    }
//    public int getNumCircles()
//    {
//       return numCircles;
//    }
//    public void setNumCircles(int n)
//    {
//        numCircles = n;
//        this.getChildren().clear();
//        for (int i = 0; i < numCircles; i++)
//           this.getChildren().add(new Circle(10,fill));
//    }

   public void userShip()
   {
      Image xImage = new Image("ship.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userNothing()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      // this.setStyle("-fx-border-width: 5;" +
//                    "-fx-border-color: black;");
//       Text t = new Text(this.cellStatus.toString());
//          t.setFont(Font.font("Ariel",24));
//          t.setTextAlignment(TextAlignment.CENTER);
//         // textArea.setStyle("-fx-background-color:yellow;");
//          stackPane.getChildren().add(t);

      //StackPane stackPane = new StackPane();
      //stackPane.getChildren().addAll(iv1, hbox); // hbox with button and text on top of image view

      //HBox root = new HBox();
      this.getChildren().add(stackPane);
      // waitingForKey.setTextAlignment(TextAlignment.CENTER);
   }
   public void userHit()
   {
      Image xImage = new Image("userHit.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userSunk()
   {
      Image xImage = new Image("userSunk.gif",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void computerHit()
   {
      Image xImage = new Image("computerNothing.gif",83,83,false,false);
      Image xImage2 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      // this.setStyle("-fx-border-width: 5;" +
//                    "-fx-border-color: black;");
      //Text t = new Text(this.cellStatus.toString());
      //  t.setFont(Font.font("Ariel",24));
      //  t.setTextAlignment(TextAlignment.CENTER);
      // textArea.setStyle("-fx-background-color:yellow;");
      // stackPane.getChildren().add(t);

      //StackPane stackPane = new StackPane();
      //stackPane.getChildren().addAll(iv1, hbox); // hbox with button and text on top of image view

      //HBox root = new HBox();
      this.getChildren().add(stackPane);

   }
   public void computerSunk()
   {
      Image xImage = new Image("userSunk.gif",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void computerNothing()
   {
      Image xImage = new Image("computerNothing.gif",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void computerShip()
   {
      Image xImage = new Image("computerNothing.gif",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      stackPane.getChildren().add(imageView);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void computerNothingHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("x.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userNothingHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("x.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      // this.setStyle("-fx-border-width: 5;" +
//                    "-fx-border-color: black;");
      //Text t = new Text(this.cellStatus.toString());
      //  t.setFont(Font.font("Ariel",24));
      //  t.setTextAlignment(TextAlignment.CENTER);
      // textArea.setStyle("-fx-background-color:yellow;");
      // stackPane.getChildren().add(t);

      //StackPane stackPane = new StackPane();
      //stackPane.getChildren().addAll(iv1, hbox); // hbox with button and text on top of image view

      //HBox root = new HBox();
      this.getChildren().add(stackPane);

   }


   public void userTop()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("top.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userBottom()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("bottom.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userV()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("v.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }

   public void userLeft()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("left.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userRight()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("right.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userH()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("h.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userTopHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("top.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userBottomHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("bottom.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userLeftHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("left.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userRightHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("right.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userHHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("h.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
   public void userVHit()
   {
      Image xImage = new Image("water.gif",83,83,false,false);
      Image xImage2 = new Image("v.png",83,83,false,false);
      Image xImage3 = new Image("small.png",83,83,false,false);
      StackPane stackPane = new StackPane();
      ImageView imageView = new ImageView(xImage);
      ImageView imageView2 = new ImageView(xImage2);
      ImageView imageView3 = new ImageView(xImage3);
      stackPane.getChildren().add(imageView);
      stackPane.getChildren().add(imageView2);
      stackPane.getChildren().add(imageView3);


      this.row = row;
      this.col = col;
      this.cellStatus = cellStatus;
      this.userBoard = userBoard;
      this.setAlignment(Pos.CENTER);
      this.setPrefSize(83,83);
      this.getChildren().add(stackPane);
   }
}