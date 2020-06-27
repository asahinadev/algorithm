package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class MageSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		List<E> temp = new ArrayList<>(list);

		merge_sort(result, temp, 0, list.size());

		return result;
	}

	protected <E extends Comparable<? super E>> void merge_sort(List<E> result, List<E> tempList, int left, int right) {
		int mid;
		if (left == right || left == right - 1) {
			return;
		}
		mid = (left + right) / 2;
		merge_sort(result, tempList, left, mid);
		merge_sort(result, tempList, mid, right);
		merge(result, tempList, left, mid, right);
	}

	protected <E extends Comparable<? super E>> void merge(
			List<E> result, List<E> tempList, int left, int mid, int right) {
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
		if (i == mid) { /* i‘¤‚ÌA‚ðB‚ÉˆÚ“®‚µs‚­‚µ‚½‚Ì‚ÅAj‘¤‚à‡”Ô‚ÉB‚É“ü‚ê‚Ä‚¢‚­ */
			while (j < right) {
				tempList.set(k++, result.get(j++));
			}
		} else {
			while (i < mid) { /* j‘¤‚ÌA‚ðB‚ÉˆÚ“®‚µs‚­‚µ‚½‚Ì‚ÅAi‘¤‚à‡”Ô‚ÉB‚É“ü‚ê‚Ä‚¢‚­ */
				tempList.set(k++, result.get(i++));
			}
		}
		for (l = 0; l < k; l++) {
			result.set(left + l, tempList.get(l));
		}
	}

	protected <E extends Comparable<? super E>> boolean swap(List<E> result, int i, int j) {
		throw new UnsupportedOperationException();
	}

	protected <E extends Comparable<? super E>> boolean hasSwap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		if (a.compareTo(b) > 0) {
			return true;
		}
		return false;
	}
}
