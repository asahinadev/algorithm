package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmoothSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {

		List<E> result = new ArrayList<>(list);
		sort(result);
		return result;
	}

	void sort(List<E> result) {

		if (result.size() == 0) {
			return;
		}

		int head = 0;
		long frac = 0;
		int exp = 0;

		while (head < result.size()) {

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
			if (exp > 0 && result.size() - head - 1 < leonardo(exp - 1) + 1) {
				arrange(result, head, frac, exp);
			}
			sift(result, head, exp);
			head++;
		}
		arrange(result, head - 1, frac, exp);
		while (head > 0) {
			head--;
			if (exp > 1) {
				frac <<= 2;
				frac--;
				exp -= 2;
				arrange(result, head - leonardo(exp) - 1, frac >> 1, exp + 1);
				arrange(result, head - 1, frac, exp);
			} else {
				int trail = Long.numberOfTrailingZeros(frac - 1);
				frac >>= trail;
				exp += trail;
			}
		}
	}

	private static int[] memo = { 1, 1 };

	int leonardo(int n) {
		if (n < memo.length) {
			if (memo[n] != 0) {
				return memo[n];
			}
		} else {
			int newLength = memo.length * 2;
			memo = Arrays.copyOf(memo, (newLength > n) ? newLength : (n + 1));
		}
		return memo[n] = leonardo(n - 1) + leonardo(n - 2) + 1;
	}

	void sift(List<E> result, int head, int exp) {
		E t = result.get(head);
		while (exp > 1) {
			int r = head - 1;
			int l = head - 1 - leonardo(exp - 2);

			E left = result.get(l);
			E right = result.get(r);

			if (compareTo(t, left) >= 0 && compareTo(t, right) >= 0) {
				break;
			}
			if (compareTo(left, right) >= 0) {
				result.set(head, left);
				head = l;
				exp -= 1;
			} else {
				result.set(head, right);
				head = r;
				exp -= 2;
			}
		}
		result.set(head, t);
	}

	void arrange(List<E> v, int head, long frac, int exp) {
		E t = v.get(head);
		while (frac > 1) {
			int next = head - leonardo(exp);
			E target = v.get(next);
			if (compareTo(t, target) >= 0) {
				break;
			}
			if (exp > 1) {
				int r = head - 1;
				int l = head - 1 - leonardo(exp - 2);

				E left = v.get(l);
				E right = v.get(r);

				if (compareTo(left, target) >= 0
						|| compareTo(right, target) >= 0) {
					break;
				}
			}

			v.set(head, v.get(next));
			head = next;
			int trail = Long.numberOfTrailingZeros(frac - 1);
			frac >>>= trail;
			exp += trail;
		}
		v.set(head, t);
		sift(v, head, exp);
	}
}
