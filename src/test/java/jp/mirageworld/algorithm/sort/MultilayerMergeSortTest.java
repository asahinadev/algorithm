package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MultilayerMergeSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO ƒAƒ‹ƒSƒŠƒYƒ€’²¸’†
		assertThrows(
				UnsupportedOperationException.class, () -> new MultilayerMergeSort().apply(list));
	}
}
