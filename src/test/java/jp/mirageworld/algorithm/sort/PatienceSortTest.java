package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PatienceSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO �A���S���Y��������
		assertThrows(
				UnsupportedOperationException.class,
				() -> new PatienceSort<Integer>().apply(list));
	}
}
