package jp.mirageworld.algorithm.search;

import java.util.List;

public class TrinitySearch {

	int curr;

	public <T extends Comparable<T>> int apply(List<T> list, T target) {
		if (check(list, target)) {
			return curr;
		}
		return -1;
	}

	public <T extends Comparable<T>> boolean check(List<T> list, T target) {
		int start = 0;
		int end = list.size() - 1;

		while (true) {

			int len = end - start;
			int post = len / 3;

			int curr1 = start + post;
			int curr2 = end - post;

			T currObj1 = list.get(curr1);
			T currObj2 = list.get(curr2);

			int compare1 = target.compareTo(currObj1);
			int compare2 = target.compareTo(currObj2);

			if (compare1 == 0) {
				curr = curr1;
			} else if (compare2 == 0) {
				curr = curr2;
			} else if (len < 3) {
				// 3Œ–¢–ž‚Ìê‡‚Íƒ‹[ƒv‚µ‚È‚¢
				return false;
			} else if (compare1 < 0) {
				end = curr1 - 1;
				continue;
			} else if (compare2 < 0) {
				start = curr1 + 1;
				end = curr2 - 1;
				continue;
			} else {
				start = curr2 + 1;
				continue;
			}
			return true;
		}
	}
}