package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class CombSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		int h = list.size() * 10 / 13;
		while (true) {
			int swaps = 0;
			for (int i = 0, j = i + h; i + h < list.size(); ++i, j = i + h) {
				E a = result.get(i);
				E b = result.get(j);
				if (a.compareTo(b) > 0) {
					result.set(i, b);
					result.set(j, a);
					swaps++;
				}
			}
			if (h == 1) {
				if (swaps == 0) {
					break;
				}
			} else {
				h = h * 10 / 13;
			}
		}
		return result;
	}
}
