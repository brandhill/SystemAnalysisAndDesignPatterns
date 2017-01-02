package SingletonPattern;

import FactoryPattern.mainclass;

public class Singleton {
	private static Singleton singleton = null;
	private Singleton() {
		
	}
	
	static Singleton getInstance() {
		if(singleton==null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
