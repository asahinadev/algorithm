package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BurstSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO �A���S���Y��������
		assertThrows(
				UnsupportedOperationException.class,
				() -> new BurstSort<Integer>().apply(list));
	}
}
