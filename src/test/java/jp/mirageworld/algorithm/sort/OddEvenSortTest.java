package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class OddEvenSortTest {

	@Test
	void test() {
		List<Integer> list = IntStream.of(8, 4, 3, 7, 6, 5, 2, 1).boxed().collect(Collectors.toList());

		OddEvenSort eos = new OddEvenSort();

		List<Integer> result = eos.apply(list);
		int loopCount = eos.getLoopCount();
		int chgCount = eos.getChgCount();

		System.out.println(result);

		assertEquals(8, loopCount); // バブルソートは 7
		assertEquals(22, chgCount); // バブルソートは 22

		for (int i = 1; i < result.size(); i++) {
			int a = result.get(1 - 1);
			int b = result.get(1 - 0);
			assertTrue(a < b);
		}
	}
}
