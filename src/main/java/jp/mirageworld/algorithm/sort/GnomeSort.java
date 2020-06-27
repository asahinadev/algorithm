package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class GnomeSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);
		while (true) {
			boolean flag = false;
			for (int i = 0, j = 1; j < list.size();) {
				if (swap(result, i, j)) {
					flag = true;
					i = i == 0 ? 0 : i - 1;
				} else {
					i++;
				}
				j = i + 1;
			}
			if (!flag)
				break;
		}
		return result;
	}
}
