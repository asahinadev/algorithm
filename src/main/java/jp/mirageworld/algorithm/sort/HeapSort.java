package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
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

	private <E extends Comparable<? super E>> void upheap(List<E> result, int n) {
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

	private <E extends Comparable<? super E>> void downheap(List<E> result, int n) {
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

	protected <E extends Comparable<? super E>> boolean swap(List<E> result, int i, int j) {
		E a = result.get(i);
		E b = result.get(j);
		result.set(i, b);
		result.set(j, a);
		return true;
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
