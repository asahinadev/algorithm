package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class ShakerSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		int top = 0;
		int bottom = list.size() - 1;
		while (true) {
			// �������̃X�L����
			int last = top;
			for (int i = top, j = i + 1; i < bottom; i++, j++) {
				if (swap(result, i, j)) {
					last = i;
				}
			}

			// �t�����̃X�L���� �͈͂����߂�
			bottom = last;
			if (top == bottom)
				break;

			/* �t�����̃X�L���� */
			for (int i = bottom, j = i - 1; i > top; i--, j--) {
				if (swap(result, j, i)) {
					last = i;
				}
			}

			// �������̃X�L���� �͈͂����߂�
			top = last;
			if (top == bottom)
				break;
		}
		return result;
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
