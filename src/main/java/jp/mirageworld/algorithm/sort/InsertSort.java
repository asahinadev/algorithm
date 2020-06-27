package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertSort<E extends Comparable<? super E>>
		implements Sort<E> {

	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		for (int i = 1; i < result.size(); i++) {
			E tmp = result.get(i);
			E tag = result.get(i - 1);
			if (tag.compareTo(tmp) > 0) {
				int j = i;
				int k = 0;
				do {
					k = j - 1;
					result.set(j, result.get(k));
					j--;
				} while (j > 0 && result.get(j - 1).compareTo(tmp) > 0);
				result.set(j, tmp);
			}
		}
		return result;
	}
}
