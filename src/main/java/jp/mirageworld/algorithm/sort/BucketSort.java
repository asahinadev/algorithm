package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BucketSort {

	public <E extends Comparable<? super E>> List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);

		// �o���񐔁iOFFSET �p�j
		Map<E, Integer> count = new HashMap<E, Integer>();

		// �J�n�ʒu
		Map<E, Integer> offset = new TreeMap<E, Integer>();

		for (E element : list) {
			countup(count, element);
			offset.put(element, 0);
		}

		// �J�n�ʒu�v�Z
		Map.Entry<E, Integer> prev = null;
		for (Map.Entry<E, Integer> entry : offset.entrySet()) {
			int o = 0;
			if (prev != null) {
				o += prev.getValue() + count.get(prev.getKey());
			}
			entry.setValue(o);
			prev = entry;
		}
		count.clear();

		// �\�[�g����
		for (E element : list) {
			result.set(offset.get(element) + countGet(count, element), element);
			countup(count, element);
		}

		return result;
	}

	protected <E extends Comparable<? super E>> void countup(Map<E, Integer> count, E key) {
		if (!count.containsKey(key)) {
			count.put(key, 0);
		}
		count.put(key, count.get(key) + 1);
	}

	protected <E extends Comparable<? super E>> int countGet(Map<E, Integer> count, E key) {
		if (!count.containsKey(key)) {
			return 0;
		}
		return count.get(key);
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