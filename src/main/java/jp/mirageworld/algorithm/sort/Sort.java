package jp.mirageworld.algorithm.sort;

import java.util.List;

public interface Sort<E extends Comparable<? super E>> {

	public List<E> apply(List<E> list);

	/**
	 * (compareTo(a, b) > 0) の判定。
	 * 
	 * @param result 対象リスト
	 * @param i      インデックス１
	 * @param j      インデックス２
	 * @return 交換済み
	 */
	default boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (compareTo(a, b) > 0) {
			result.set(i, b);
			result.set(j, a);
			return true;
		}
		return false;
	}

	/**
	 * (compareTo(a, b) > 0) の判定。
	 * 
	 * @param result 対象リスト
	 * @param i      インデックス１
	 * @param j      インデックス２
	 * @return 交換可能
	 */
	default boolean hasSwap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (compareTo(a, b) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * ヌルセーフ.
	 * 
	 * @param a 対象１
	 * @param b 対象２
	 * 
	 * @return a.compareTo(b);
	 */
	default int compareTo(E a, E b) {
		if (a == b) {
			return 0;
		} else if (a == null) {
			return -1;
		} else if (b == null) {
			return 1;
		}
		return a.compareTo(b);
	}
}
