package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmoothSort<E extends Comparable<? super E>>
		implements Sort<E> {

	int[] memo = { 1, 1 };

	public List<E> apply(List<E> list) {

		List<E> result = new ArrayList<>(list);
		sort(result);
		return result;
	}

	void sort(List<E> list) {
		if (list.isEmpty())
			return;

		int len = list.size();
		int head = 0;
		long frac = 0;
		int exp = 0;

		while (head < len) {
			if ((frac & 3) == 3) {
				frac >>>= 2;
				exp += 2;
			} else if (exp > 1) {
				frac <<= exp - 1;
				exp = 1;
			} else {
				frac <<= exp;
				exp ^= 1;
			}
			frac++;
			if (exp > 0 && len - head - 1 < leonardo(exp - 1) + 1) {
				arrange(list, head, frac, exp);
			}
			sift(list, head, exp);
			head++;
		}
		arrange(list, head - 1, frac, exp);
		while (head > 0) {
			head--;
			if (exp > 1) {
				frac <<= 2;
				frac--;
				exp -= 2;
				arrange(list, head - leonardo(exp) - 1, frac >> 1, exp + 1);
				arrange(list, head - 1, frac, exp);
			} else {
				int trail = Long.numberOfTrailingZeros(frac - 1);
				frac >>= trail;
				exp += trail;
			}
		}
	}

	int leonardo(int n) {
		if (n < memo.length) {
			if (memo[n] != 0) {
				return memo[n];
			}
		} else {
			int newLength = memo.length * 2;
			memo = Arrays.copyOf(memo, (newLength > n) ? newLength : (n + 1));
		}
		return memo[n] = leonardo(n - 1)
				+ leonardo(n - 2) + 1;
	}

	void sift(List<E> list, int head, int exp) {

		E t = list.get(head);
		while (exp > 1) {
			int li = head - 1;
			int ri = head - 1 - leonardo(exp - 2);

			E r = list.get(ri);
			E l = list.get(li);

			if (t.compareTo(l) >= 0 && t.compareTo(r) >= 0) {
				break;
			} else if (l.compareTo(r) >= 0) {
				list.set(head, l);
				head = li;
				exp -= 1;
				continue;
			}
			list.set(head, r);
			head = ri;
			exp -= 2;
		}
		list.set(head, t);
	}

	void arrange(List<E> list, int head, long frac, int exp) {
		E t = list.get(head);

		while (frac > 1) {
			int next = head - leonardo(exp);
			E n = list.get(next);

			if (t.compareTo(list.get(next)) >= 0) {
				break;
			}
			if (exp > 1) {
				int li = head - 1;
				int ri = head - 1 - leonardo(exp - 2);

				E r = list.get(ri);
				E l = list.get(li);

				if (l.compareTo(n) >= 0 || r.compareTo(n) >= 0) {
					break;
				}
			}

			list.set(head, n);

			head = next;

			int trail = Long.numberOfTrailingZeros(frac - 1);
			frac >>>= trail;
			exp += trail;
		}

		list.set(head, t);
		sift(list, head, exp);
	}
}
