package xzrt.MultiPlane;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;

public class Layer {

	private float[] boundingBox;
	private PShape s;
	private PGraphics g;
	private boolean isUpdated = false;
	private boolean isActive = false;
	private PApplet applet;
	
	public Layer(PShape s, PApplet applet){
		this.s = s;
		this.applet = applet;
	}
	
	/**
	 * Get an array with the bounding box
	 * @return an array of size 4 (TL x, TL y, BR x, BR y)
	 */
	public float[] getBoundingBox(){
		if (!isUpdated) {
			update();
		}
		return boundingBox;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public float[] getBoundingPolygon(){
		return null;
		//TODO Make
		
	}
	
	/**
	 * 
	 * @return
	 */
	public PImage getMasked(){
		return null; //TODO make this
	}
	
	
	public void setImage(){
		//TODO make this
	}
	
	public void update(){
		//TODO make this
		isUpdated = true;
	}

	/**
	 * allocate memory and calculate bounds for this layer 
	 */
	private void activate(){
		if (isActive) return;
		calculateBoundingBox();
		g = applet.createGraphics((int) (boundingBox[2] - boundingBox[0]), (int)(boundingBox[3] - boundingBox[1]));
	}
	
	/**
	 * Calculates the bounding box by taking all of the shapes. works only for polygons.
	 * 
	 */
	private void calculateBoundingBox() {
		//TODO have it work for curves
		int n = s.getVertexCount();
		
		PVector min = new PVector();
		PVector max = new PVector();
		
		if ( n > 0 ) {
			min.x = max.x = s.getVertexX(0);
			min.y = max.y = s.getVertexY(0);
		}

		PVector current = new PVector();
		for (int j = 0 ; j < n ; j++){
			current.x = s.getVertexX(j);
			current.y = s.getVertexY(j);
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
		boundingBox = new float[]{min.x,min.y,max.x,max.y};
	}
}
