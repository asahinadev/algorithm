package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TournamentSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO アルゴリズム調査中
		assertThrows(
				UnsupportedOperationException.class,
				() -> new TournamentSort<Integer>().apply(list));
	}
}
