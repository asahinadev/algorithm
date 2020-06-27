package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		while (true) {
			boolean flag = false;
			for (int i = 0, j = 1; j < list.size(); i += 2, j += 2) {
				flag |= swap(result, i, j);
			}
			for (int i = 1, j = 2; j < list.size(); i += 2, j += 2) {
				flag |= swap(result, i, j);
			}
			if (!flag)
				break;
		}
		return result;
	}
}
