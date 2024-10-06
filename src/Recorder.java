import java.util.HashMap;

public class Recorder {
	private HashMap<String, String> map = new HashMap<>();

	public void put(String key, String value) {
		map.put(key, value);
		System.out.println(key + "=" + value);
	}

	public void get(String key) {
		if (!map.containsKey(key)) {
			throw new IllegalArgumentException();
		}
		System.out.println(map.get(key));
	}

	public void delete(String key) {
		if (!map.containsKey(key)) {
			throw new IllegalArgumentException();
		}
		map.remove(key);
		System.out.println("deleted:" + key);
	}

	public void delete() {
		map.clear();
		System.out.println("deleted all");

	}

}
