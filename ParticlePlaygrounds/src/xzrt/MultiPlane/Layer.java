package xzrt.MultiPlane;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PShape;

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

	private void activate(){
		if (isActive) return;
		calculateBoundingBox();
		g = applet.createGraphics(boundingBox[2] - boundingBox[0], boundingBox[3] - boundingBox[1], renderer);
	}

	private void calculateBoundingBox() {
		// TODO Auto-generated method stub
		
	}
}
