package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BucketSort<E extends Comparable<? super E>>
		implements Sort<E> {

	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>(list);

		// 出現回数（OFFSET 用）
		Map<E, Integer> count = new HashMap<E, Integer>();

		// 開始位置
		Map<E, Integer> offset = new TreeMap<E, Integer>();

		for (E element : list) {
			countup(count, element);
			offset.put(element, 0);
		}

		// 開始位置計算
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

		// ソート処理
		for (E element : list) {
			result.set(offset.get(element) + countGet(count, element), element);
			countup(count, element);
		}

		return result;
	}

	void countup(Map<E, Integer> count, E key) {
		if (!count.containsKey(key)) {
			count.put(key, 0);
		}
		count.put(key, count.get(key) + 1);
	}

	int countGet(Map<E, Integer> count, E key) {
		if (!count.containsKey(key)) {
			return 0;
		}
		return count.get(key);
	}
}
