package jp.mirageworld.algorithm.shuffle;

import org.junit.jupiter.api.Test;

class RandomShuffleTest extends AbstractShuffleTest {

	@Test
	void test() {
		super.shuffleTest(new RandomShuffle().apply(list));
	}

}
