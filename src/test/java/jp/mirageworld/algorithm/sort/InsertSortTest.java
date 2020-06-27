package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class InsertSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new InsertSort().apply(list));
	}
}
