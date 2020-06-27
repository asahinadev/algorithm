package jp.mirageworld.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class BinaryInsertSort<E extends Comparable<? super E>>
		implements Sort<E> {

	@Override
	public List<E> apply(List<E> list) {

		List<E> result = new ArrayList<>(list);

		for (int sorted = 1; sorted < result.size(); sorted++) {
			// �\�[�g�ςݗ̈�̒���̒l
			E insert = result.get(sorted);

			// �o�C�i���T�[�`
			int left = 0;
			int right = sorted;
			while (left < right) {
				int mid = (left + right) / 2;

				if (compareTo(result.get(mid), insert) < 0) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			int i = left;

			// �}���\�[�g
			while (i <= sorted) {
				E temp = result.get(i);
				result.set(i, insert);
				insert = temp;
				i++;
			}
		}
		return result;
	}
}
