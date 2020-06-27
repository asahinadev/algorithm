package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class HeapSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new HeapSort<Integer>().apply(list));
	}
}
