package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
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

	protected <E extends Comparable<? super E>> boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (a.compareTo(b) > 0) {
			result.set(i, b);
			result.set(j, a);
			return true;
		}
		return false;
	}
}
