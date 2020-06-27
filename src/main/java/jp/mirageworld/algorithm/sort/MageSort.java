package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class MageSort<E extends Comparable<? super E>>
		implements Sort<E> {

	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		List<E> temp = new ArrayList<>(list);

		sort(result, temp, 0, list.size());

		return result;
	}

	void sort(List<E> result, List<E> tempList, int left, int right) {
		int mid;
		if (left == right || left == right - 1) {
			return;
		}
		mid = (left + right) / 2;
		sort(result, tempList, left, mid);
		sort(result, tempList, mid, right);
		merge(result, tempList, left, mid, right);
	}

	void merge(List<E> result, List<E> tempList, int left, int mid, int right) {
		int i = left;
		int j = mid;
		int k = 0;
		int l;
		while (i < mid && j < right) {
			if (!hasSwap(result, i, j)) {
				tempList.set(k++, result.get(i++));
			} else {
				tempList.set(k++, result.get(j++));
			}
		}
		if (i == mid) {
			while (j < right) {
				tempList.set(k++, result.get(j++));
			}
		} else {
			while (i < mid) {
				tempList.set(k++, result.get(i++));
			}
		}
		for (l = 0; l < k; l++) {
			result.set(left + l, tempList.get(l));
		}
	}
}
