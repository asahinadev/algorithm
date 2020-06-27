package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class GnomeSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new GnomeSort<Integer>().apply(list));
	}
}
