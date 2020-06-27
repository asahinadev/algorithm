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
			// 順方向のスキャン
			int last = top;
			for (int i = top, j = i + 1; i < bottom; i++, j++) {
				if (swap(result, i, j)) {
					last = i;
				}
			}

			// 逆方向のスキャン 範囲を狭める
			bottom = last;
			if (top == bottom)
				break;

			/* 逆方向のスキャン */
			for (int i = bottom, j = i - 1; i > top; i--, j--) {
				if (swap(result, j, i)) {
					last = i;
				}
			}

			// 順方向のスキャン 範囲を狭める
			top = last;
			if (top == bottom)
				break;
		}
		return result;
	}
}
