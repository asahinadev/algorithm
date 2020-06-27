package jp.mirageworld.algorithm.sort;

import java.util.List;

public interface Sort<E extends Comparable<? super E>> {

	public List<E> apply(List<E> list);

	/**
	 * (compareTo(a, b) > 0) �̔���B
	 * 
	 * @param result �Ώۃ��X�g
	 * @param i      �C���f�b�N�X�P
	 * @param j      �C���f�b�N�X�Q
	 * @return �����ς�
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
	 * (compareTo(a, b) > 0) �̔���B
	 * 
	 * @param result �Ώۃ��X�g
	 * @param i      �C���f�b�N�X�P
	 * @param j      �C���f�b�N�X�Q
	 * @return �����\
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
	 * �k���Z�[�t.
	 * 
	 * @param a �ΏۂP
	 * @param b �ΏۂQ
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
