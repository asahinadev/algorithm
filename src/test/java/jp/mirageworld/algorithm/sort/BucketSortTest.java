package jp.mirageworld.algorithm.sort;

import org.junit.jupiter.api.Test;

class BucketSortTest extends AbstractSortTest {

	@Test
	void test() {
		super.sortTest(new BucketSort().apply(list));
	}
}
