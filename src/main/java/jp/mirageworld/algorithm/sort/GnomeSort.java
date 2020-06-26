package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class GnomeSort {

	int loopCount = 0;
	int chgCount = 0;

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		while (true) {
			boolean flag = false;

			for (int i = 0, j = 1; j < list.size();) {
				E a = result.get(i);
				E b = result.get(j);

				if (a.compareTo(b) > 0) {
					result.set(i, b);
					result.set(j, a);
					chgCount++;
					flag = true;

					i = i == 0 ? 0 : i - 1;
				} else {
					i++;
				}
				j = i + 1;
			}

			if (flag) {
				loopCount++;
			} else {
				break;
			}
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
