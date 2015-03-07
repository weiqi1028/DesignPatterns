import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;

class EventSource extends Observable implements Runnable {

	public void run() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while (true) {
			String res;
			try {
				res = br.readLine();
				setChanged();
				notifyObservers(res);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ResponseHandler implements Observer {
	public void update(Observable o, Object arg) {
		if (arg instanceof String);
		System.out.println("Observer received: " + (String)arg);
	}
	
}

public class ObserverPattern {
	public static void main(String[] args) {
		EventSource source = new EventSource();
		ResponseHandler handler = new ResponseHandler();
		ResponseHandler handler2 = new ResponseHandler();
		source.addObserver(handler);
		source.addObserver(handler2);
		
		Thread thread = new Thread(source);
		thread.start();
	}
}
