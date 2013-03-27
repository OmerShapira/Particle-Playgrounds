package ITP.playful.Particle.Event;

import java.awt.EventQueue;

public class EventManager {

	EventQueue q;
	static EventManager instance = null;

	protected EventManager(){
		q = new EventQueue();
	}

	/**
	 * Returns the EventManager object. If it hasn't been instantiated, it gets instantiated.
	 * @return An EventManager singleton
	 */
	public static EventManager getEventManager(){
		if (instance == null){
			instance = new EventManager();
		}
		return instance;
	}
}
