package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StrandSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {
		List<E> result = new ArrayList<>();
		while (!list.isEmpty()) {
			result = merge(result, subList(list));
		}
		return result;
	}

	List<E> merge(List<E> list1, List<E> list2) {

		ListIterator<E> iter1 = list1.listIterator();
		ListIterator<E> iter2 = list2.listIterator();

		List<E> result = new LinkedList<E>();
		if (!iter1.hasNext()) {
			return list2;
		}
		if (!iter2.hasNext()) {
			return list1;
		}
		E item1 = iter1.next();
		E item2 = iter2.next();
		for (;;) {
			if (compareTo(item1, item2) < 0) {
				result.add(item1);
				if (iter1.hasNext()) {
					item1 = iter1.next();
				} else {
					result.add(item2);
					while (iter2.hasNext()) {
						result.add(iter2.next());
					}
					break;
				}
			} else {
				result.add(item2);
				if (iter2.hasNext()) {
					item2 = iter2.next();
				} else {
					result.add(item1);
					while (iter1.hasNext()) {
						result.add(iter1.next());
					}
					break;
				}
			}
		}
		return result;
	}

	List<E> subList(List<E> list) {
		ListIterator<E> iter = list.listIterator();
		if (!iter.hasNext()) {
			return Collections.<E>emptyList();
		}

		List<E> result = new LinkedList<E>();
		E max = iter.next();
		iter.remove();
		result.add(max);
		while (iter.hasNext()) {
			E tmp = iter.next();
			if (compareTo(tmp, max) > 0) {
				iter.remove();
				result.add(max = tmp);
			}
		}
		return result;
	}

}
