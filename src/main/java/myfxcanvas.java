import java.awt.Canvas;
import java.util.Collection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.GraphicsContext;

public class myfxcanvas extends Application {

    public static void launch(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
Group group;
GraphicsContext gc;
  
   // launch the application
    @Override
   public void start(Stage stage)
   {
       // set title for the stage
       stage.setTitle("creating canvas");
       // create a canvas
       Canvas can;
        can = new Canvas(600.0f, 600.0f);
       // graphics context
       gc = can.getGraphicsContext2D();   
       // create a Group
       group = new Group((Collection<Node>) can);
draw1();
       // create a scene
       Scene scene = new Scene(group, 600, 600);
       // set the scene
       stage.setScene(scene);
       stage.show();
   }
  
   public void draw1()
   {
//sky
gc.setFill(Color.LIGHTBLUE);
gc.fillRect(0, 0, 600, 250);

//lawn
gc.setFill(Color.LIME);
gc.fillRect(0, 250, 600, 600);
  
//triangle
Polyline triangle = new Polyline();
triangle.getPoints().addAll(new Double[]{
300.0, 0.0, //clockwise points of triangle
550.0, 150.0,
50.0, 150.0,
300.0, 0.0, }); //same as first
triangle.setStroke(Color.BLACK);
triangle.setFill(Color.WHITE);
group.getChildren().add(triangle);
  
//rectabgle below triangle
Rectangle rect = new Rectangle(70, 150, 460, 30);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//rectabgle brown / wall
rect = new Rectangle(70, 180, 460, 330);
rect.setFill(Color.CHOCOLATE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

//window center
rect = new Rectangle(260, 210, 80, 40);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//door1
rect = new Rectangle(125, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//door1 blacks
doorblacks(142, 310);
//door1 pillar
pillar(80, 180);
  
//door2
rect = new Rectangle(260, 275, 80, 190);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//door2 blacks
doorblacks(277, 310);
//door2 pillar
pillar(215, 180);
  
//door3
rect = new Rectangle(395, 295, 80, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//door3 blacks
doorblacks(412, 310);
//door3 pillar
pillar(350, 180);
//last pillar
pillar(485, 180);
  
//rect below doors
rect = new Rectangle(70, 460, 460, 5);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
stairs(120, 460);
  
// Sun
//gc.setFill(Color.ORANGE);
//gc.fillOval(30, 30, 70, 70);
      
   }
  
public void doorblacks(int x, int y)
{
Rectangle rect;
  
for(int i = 0, j=0; i<5; i++, j+=30)
{
rect = new Rectangle( x, y+j, 15, 25 ); //black left
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
rect = new Rectangle( x+30, y+j, 15, 25 ); //black right
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
}
}
  
public void pillar(int x, int y)
{
Rectangle rect;
int width=35, height=270;
  
rect = new Rectangle( x, y, width, height ); //pillar
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
rect = new Rectangle( x-5, y+height, 45, 10 ); ////pillar base
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
  
//circles
Circle circle1 = new Circle();
//Setting the properties of the circle
int radius=11;
circle1.setFill(Color.WHITE);
circle1.setStroke(Color.BLACK);
circle1.setRadius(radius);
circle1.setCenterX(x);
circle1.setCenterY(y+radius);
group.getChildren().add(circle1);

Circle circle2 = new Circle();
//Setting the properties of the circle   
circle2.setFill(Color.WHITE);
circle2.setStroke(Color.BLACK);
circle2.setRadius(radius);
circle2.setCenterX(x+width);
circle2.setCenterY(y+radius);
group.getChildren().add(circle2);
}
  
public void stairs(int x, int y)
{
Rectangle rect;
int width=360, height=10;
  
for(int i=1; i<=11; i++)
{
rect = new Rectangle(x, y, width, 10);
rect.setFill(Color.LIGHTGRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);   
x= x-10; //decrease x for next stair by 10
y= y+height; //increase y for next stair
width = width + 20; //increase width for next stair by 10
}
}

   // Main Method
   public static void main(String args[])
   {
// launch the application
launch(args);
   }
}
