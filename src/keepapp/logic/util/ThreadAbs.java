package keepapp.logic.util;

public abstract class ThreadAbs implements Runnable {
	Thread t;
	public ThreadAbs(String name) {
		// TODO Auto-generated constructor stub
		t = new Thread(this, name);
		t.start();
	}

	@Override
	public abstract void run();

}
