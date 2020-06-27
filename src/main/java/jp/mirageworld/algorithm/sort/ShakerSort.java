package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class ShakerSort<E extends Comparable<? super E>>
		implements Sort<E> {

	public List<E> apply(List<E> list) {
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
}
