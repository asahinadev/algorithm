package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class ShakerSort {

	int loopCount = 0;
	int chgCount = 0;

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);

		int top = 0;
		int bottom = list.size() - 1;

		while (true) {

			boolean change1 = false;
			boolean change2 = false;

			// 順方向のスキャン
			int last = top;
			for (int i = top, j = i + 1; i < bottom; i++, j++) {
				E a = result.get(i);
				E b = result.get(j);
				if (a.compareTo(b) > 0) {
					result.set(i, b);
					result.set(j, a);
					chgCount++;
					change1 = true;
					last = i;
				}
			}

			// 逆方向のスキャン 範囲を狭める
			bottom = last;
			if (change1)
				loopCount++;

			if (top == bottom)
				break;

			/* 逆方向のスキャン */
			for (int i = bottom, j = i - 1; i > top; i--, j--) {
				E a = result.get(i);
				E b = result.get(j);
				if (a.compareTo(b) < 0) {
					result.set(i, b);
					result.set(j, a);
					chgCount++;
					change2 = true;
					last = i;
				}
			}

			// 順方向のスキャン 範囲を狭める
			top = last;
			if (change2)
				loopCount++;

			if (top == bottom)
				break;
		}
		return result;

	}

	public int getLoopCount() {
		return loopCount;
	}

	public int getChgCount() {
		return chgCount;
	}
}
