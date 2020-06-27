package jp.mirageworld.algorithm.search;

import java.util.List;
import java.util.Objects;

public class BinarySearch<T extends Comparable<? super T>> implements Search<T> {

	int top = 0;
	int curr = 0;

	@Override
	public int apply(List<T> list, T target) {
		if (check(list, target)) {
			return top + curr;
		}
		return -1;
	}

	@Override
	public boolean check(List<T> list, T target) {
		int len = list.size();
		if (len == 0) {
			return false;
		}

		T currObj = list.get(curr = len / 2);
		if (Objects.equals(currObj, target)) {
			return true;
		} else if (target.compareTo(currObj) < 0) {
			return check(list.subList(0, curr), target);
		}
		top += curr + 1;
		return check(list.subList(curr + 1, list.size()), target);
	}
}