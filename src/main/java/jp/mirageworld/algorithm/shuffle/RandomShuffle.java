package jp.mirageworld.algorithm.shuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShuffle {

	public <T extends Comparable<T>> List<T> apply(List<T> list) {
		List<T> random = new ArrayList<T>(list);
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < list.size(); i++) {
			int index = r.nextInt(list.size());
			T x = random.remove(index);
			random.add(x);
		}
		return random;
	}
}
