package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {
		return sort(new ArrayList<>(list), 0, list.size() - 1);
	}

	List<E> sort(List<E> result, int left, int right) {

		if (left < right) {
			int i = left;
			int j = right;
			E pivot = med3(result.get(i), result.get(i + (j - i) / 2), result.get(j));
			while (true) {
				while (result.get(i).compareTo(pivot) < 0)
					i++;
				while (pivot.compareTo(result.get(j)) < 0)
					j--;
				if (i >= j)
					break;
				swap(result, i, j);
				i++;
				j--;
			}
			sort(result, left, i - 1);
			sort(result, j + 1, right);
		}
		return result;
	}

	E med3(E x, E y, E z) {
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

	@Override
	public boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		result.set(i, b);
		result.set(j, a);
		return true;
	}
}
