package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TournamentSortTest extends AbstractSortTest {

	@Test()
	@SuppressWarnings("deprecation")
	void test() {
		// TODO �A���S���Y��������
		assertThrows(
				UnsupportedOperationException.class, () -> new TournamentSort().apply(list));
	}
}