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
				while (compareTo(result.get(i), pivot) < 0)
					i++;
				while (compareTo(pivot, result.get(j)) < 0)
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
		if (compareTo(x, y) < 0)
			if (compareTo(y, z) < 0)
				return y;
			else if (compareTo(z, x) < 0)
				return x;
			else
				return z;
		else if (compareTo(z, y) < 0)
			return y;
		else if (compareTo(x, z) < 0)
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
