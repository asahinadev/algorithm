package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		int last = result.size();
		for (int i = 0, m = 0; i + 1 < last; i++, m = i) {
			E a = result.get(i);
			E b = result.get(m);
			for (int j = i + 1; j < last; j++) {
				if (compareTo(b, result.get(j)) > 0) {
					m = j;
					b = result.get(m);
				}
			}
			if (compareTo(a, b) > 0) {
				result.set(i, b);
				result.set(m, a);
			}
		}
		return result;
	}
}
