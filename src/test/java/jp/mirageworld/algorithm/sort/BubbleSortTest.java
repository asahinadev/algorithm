package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void test() {
		List<Integer> list = IntStream.of(8, 4, 3, 7, 6, 5, 2, 1).boxed().collect(Collectors.toList());

		BubbleSort bs = new BubbleSort();

		List<Integer> result = bs.apply(list);
		int loopCount = bs.getLoopCount();
		int chgCount = bs.getChgCount();

		System.out.println(result);

		assertEquals(7, loopCount);
		assertEquals(22, chgCount);

		for (int i = 1; i < result.size(); i++) {
			int a = result.get(1 - 1);
			int b = result.get(1 - 0);
			assertTrue(a < b);
		}
	}
}
