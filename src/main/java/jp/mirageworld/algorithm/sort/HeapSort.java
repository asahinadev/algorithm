package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<E extends Comparable<? super E>>
		implements Sort<E> {

	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);

		int i = 0;
		int n = result.size();

		while (++i < n) {
			upheap(result, i);
		}

		while (--i > 0) {
			swap(result, 0, i);
			downheap(result, i);
		}

		return result;
	}

	void upheap(List<E> result, int n) {
		while (n > 0) {
			int m = (((n) + 1) / 2 - 1);
			if (hasSwap(result, n, m)) {
				swap(result, n, m);
				n = m;
			} else {
				break;
			}
		}
	}

	void downheap(List<E> result, int n) {
		int m = 0;
		int t = 0;

		for (;;) {
			int l = (((m) + 1) * 2 - 1);
			int r = (((m) + 1) * 2);

			if (l >= n) {
				break;
			}

			if (hasSwap(result, l, t)) {
				t = l;
			}
			if (r < n) {
				if (hasSwap(result, r, t)) {
					t = r;
				}
			}
			if (t == m) {
				break;
			}
			swap(result, m, t);
			m = t;
		}
	}

	public boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		result.set(i, b);
		result.set(j, a);
		return true;
	}
}
