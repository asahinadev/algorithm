package jp.mirageworld.algorithm.sort;

import java.util.List;

@Deprecated
public class MultilayerMergeSort {

	// TODO アルゴリズム調査中
	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		throw new UnsupportedOperationException("アルゴリズム調査中");
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
