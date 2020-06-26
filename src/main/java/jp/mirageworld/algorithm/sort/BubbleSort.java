package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	int loopCount = 0;
	int chgCount = 0;

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		boolean flag;
		do {
			flag = false;

			for (int i = 1; i < list.size(); i++) {
				E a = result.get(i - 1);
				E b = result.get(i - 0);

				if (a.compareTo(b) > 0) {
					result.set(i - 1, b);
					result.set(i - 0, a);
					chgCount++;
					flag = true;
				}
			}

			if (flag) {
				loopCount++;
			}

		} while (flag);

		return result;

	}

	public int getLoopCount() {
		return loopCount;
	}

	public int getChgCount() {
		return chgCount;
	}
}
