import java.util.*;

public class RandomizedSet {
	HashMap<Integer, Integer> mapValKey;
	HashMap<Integer, Integer> mapIdxKey;
	Random rand;

	public RandomizedSet() {
		mapValKey = new HashMap<Integer, Integer>();
		mapIdxKey = new HashMap<Integer, Integer>();
		rand = new Random(System.currentTimeMillis());
	}

	public boolean insert(int val) {
		if (mapValKey.containsKey(val)) {
			return false;
		} else {
			mapValKey.put(val, mapValKey.size());
			mapIdxKey.put(mapIdxKey.size(), val);
		}
System.out.println("***Insert***");
System.out.println(mapValKey);
System.out.println(mapIdxKey);
		return true;
	}

	public boolean remove(int val) {
System.out.println("***Remove***");
		if (mapValKey.containsKey(val)) {
			int index = mapValKey.get(val);

			mapValKey.remove(val);
			mapIdxKey.remove(index);

			if (mapValKey.size() == 0) {
System.out.println("mapValKey.size() == 0");
				return true;
			}

			if (index == mapValKey.size()) {
System.out.println("index == mapValKey.size()");
				return true;
			}

			int key1 = mapIdxKey.get(mapIdxKey.size());

			// Copied the last node value at the place where the val was and removed the last node.
			mapValKey.put(key1, index);
			mapIdxKey.remove(mapIdxKey.size());
			mapIdxKey.put(index, key1);
		} else {
System.out.println("false");
			return false;
		}
System.out.println(mapValKey);
System.out.println(mapIdxKey);

		return true;
	}

	public int getRandom() {
		return mapIdxKey.get(rand.nextInt(mapValKey.size()));
	}

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(1);
		param_1 = obj.insert(2);
		param_1 = obj.insert(3);
		boolean param_2 = obj.remove(1);
		int param_3 = obj.getRandom();
		System.out.println("Random Number: " + param_3);	
	}
}
