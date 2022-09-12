import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultThread extends Thread{
	
	private long zeitNachAbbruch;
	
	public long getZeitNachAbbruch() {
		return zeitNachAbbruch;
	}

	public void setZeitNachAbbruch(long diff) {
		this.zeitNachAbbruch = diff;
	}

	@Override
	public void run() {	
		Zeitmesser zm = new Zeitmesser();
		boolean running = true;
		String line;
		long start = 0;
		boolean found = false;
		long diff;
		long znA;
		while (running & !Thread.interrupted()) {
			found = false;
			try {
				Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					if (line.contains(zm.getAnfang())) {
						found = true;
						break;
					}
				}
				if (found) {
					if (start == 0) {
						start = System.currentTimeMillis();
					} else {
						znA = (System.currentTimeMillis() - start)/1000;
						setZeitNachAbbruch(znA);
					}
				} else {
					if (start > 0) {					
						diff = (System.currentTimeMillis() - start)/1000;
						zm.setZeit(diff);
						start = 0;
						break;
					}
				}
				input.close();	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} zm.setZeit(getZeitNachAbbruch());
	}
}
