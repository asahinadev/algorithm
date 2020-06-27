package jp.mirageworld.algorithm.sort;

import java.util.List;

public interface Sort<E extends Comparable<? super E>> {

	public List<E> apply(List<E> list);

	default boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (a.compareTo(b) > 0) {
			result.set(i, b);
			result.set(j, a);
			return true;
		}
		return false;
	}

	default boolean hasSwap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (a.compareTo(b) > 0) {
			return true;
		}
		return false;
	}
}
