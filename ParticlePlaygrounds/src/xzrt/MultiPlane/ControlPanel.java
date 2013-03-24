package xzrt.MultiPlane;

import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

import controlP5.*;

public class ControlPanel extends PApplet {

	ControlP5 cp5;

	String filename = "/Users/Omer/Downloads/075_people_new/silhoutte.svg";
	PShape[] shapes;
	float squareEdge;
	int columns, rows;


	public void setup(){
		size(displayWidth, displayHeight);
		PShape s;
		s = loadShape(filename);
		shapes = s.getChildren();

		squareEdge = sqrt(width*height/shapes.length);
		columns = ceil(width/squareEdge);
		rows = ceil(height/squareEdge);
		shapeMode(CORNER);
	}

	public void draw(){

		for (int i = 0; i < shapes.length ; i++){
			PShape currentShape = shapes[i];
			int n = currentShape.getVertexCount();
			
			PVector min = new PVector();
			PVector max = new PVector();
			
			//TODO remove, it lives in "Layer"
			/** 
			 * @see Layer
			 */
			//Set Beginner
			if ( n > 0 ) {
				min.x = max.x = currentShape.getVertexX(0);
				min.y = max.y = currentShape.getVertexY(0);
			}

			//Set container
			PVector current = new PVector();
			//get bounding box
			for (int j = 0 ; j < n ; j++){
				current.x = currentShape.getVertexX(j);
				current.y = currentShape.getVertexY(j);
				if (min.x > current.x){
					min.x = current.x;
				}
				if (min.y > current.y){
					min.y = current.y;
				} 
				if (max.x < current.x){
					max.x = current.x;
				}
				if (max.y < current.y){
					max.y = current.y;
				}
			}

			pushMatrix();

			float m = max( abs(max.x-min.x), abs(max.y-min.y)); 
			translate(squareEdge*(i%columns),squareEdge*floor(i/columns));
			scale(squareEdge/m,squareEdge/m);
			translate(-min.x,-min.y);
			shape(currentShape);
			popMatrix();

		}
	}

	public static void Main(String[] args){
		PApplet.main(new String[] { "--present", "xzrt.MultiPlane.ControlPanel" });
	}


}
