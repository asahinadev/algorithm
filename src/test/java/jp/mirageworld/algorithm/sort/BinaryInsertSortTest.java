package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class BinaryInsertSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new BinaryInsertSort<Integer>().apply(list));
	}
}
