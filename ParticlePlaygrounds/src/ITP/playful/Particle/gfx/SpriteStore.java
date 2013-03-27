/**
 * 
 */
package ITP.playful.Particle.gfx;

import java.util.HashMap;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Sprite manager, only to be instantiated once.
 * @author Omer
 *
 */

public class SpriteStore {
	//Singleton
	private static SpriteStore instance = null;
	PApplet applet;

	//Data Structures
	private HashMap<String, PImage[]> anims;
	private HashMap<String, PImage> stills;

	protected SpriteStore(PApplet caller){

		//TODO make	
	}

	/**
	 * will lead to NullPointerException if not called after makeStore()
	 * @return The sprite store, even if it isn't instantiated. 
	 * 
	 */
	public static SpriteStore getStore(){
		return instance;
	}

	/**
	 * @param caller The PApplet object calling on the spite storage
	 * @return The sprite store, instantiate if it isn't there.
	 */
	public static SpriteStore getStore(PApplet caller){

		if (instance == null){
			instance = new SpriteStore(caller);
		}
		return instance;
	}




}
