package SingletonPattern;


public class ThreadSafeSingleton {
	private static volatile ThreadSafeSingleton singleton = null;
	int id;
	private ThreadSafeSingleton() {
		
	}
	
	static  ThreadSafeSingleton getInstance() {
		if(singleton==null) {
			synchronized(ThreadSafeSingleton.class) {
				if(singleton==null) {
					singleton = new ThreadSafeSingleton();
				}
			}
			
		}
		return singleton;
	}
}
