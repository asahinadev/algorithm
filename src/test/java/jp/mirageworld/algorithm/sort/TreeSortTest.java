package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TreeSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO アルゴリズム調査中
		assertThrows(
				UnsupportedOperationException.class,
				() -> new TreeSort<Integer>().apply(list));
	}
}
