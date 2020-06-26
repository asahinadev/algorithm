package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

	int loopCount = 0;
	int chgCount = 0;

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		return sort(new ArrayList<>(list), 0, list.size() - 1);
	}

	public int getLoopCount() {
		return loopCount;
	}

	public int getChgCount() {
		return chgCount;
	}

	private <E extends Comparable<? super E>> List<E> sort(List<E> list, int left, int right) {

		if (left < right) {
			int i = left;
			int j = right;
			E pivot = med3(list.get(i), list.get(i + (j - i) / 2), list.get(j));
			while (true) {
				while (list.get(i).compareTo(pivot) < 0)
					i++;
				while (pivot.compareTo(list.get(j)) < 0)
					j--;
				if (i >= j)
					break;
				E a = list.get(i);
				E b = list.get(j);

				list.set(i, b);
				list.set(j, a);

				i++;
				j--;
			}
			sort(list, left, i - 1);
			sort(list, j + 1, right);
		}

		return list;
	}

	private <E extends Comparable<? super E>> E med3(E x, E y, E z) {
		if (x.compareTo(y) < 0)
			if (y.compareTo(z) < 0)
				return y;
			else if (z.compareTo(x) < 0)
				return x;
			else
				return z;
		else if (z.compareTo(y) < 0)
			return y;
		else if (x.compareTo(z) < 0)
			return x;
		else
			return z;
	}

}