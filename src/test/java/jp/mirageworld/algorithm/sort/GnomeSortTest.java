package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class GnomeSortTest {

	@Test
	void test() {
		List<Integer> list = IntStream.of(8, 4, 3, 7, 6, 5, 2, 1).boxed().collect(Collectors.toList());

		GnomeSort gs = new GnomeSort();

		List<Integer> result = gs.apply(list);
		int loopCount = gs.getLoopCount();
		int chgCount = gs.getChgCount();

		System.out.println(result);

		assertEquals(3, loopCount); // バブルソートは 7
		assertEquals(6, chgCount); // バブルソートは 22

		for (int i = 1; i < result.size(); i++) {
			int a = result.get(1 - 1);
			int b = result.get(1 - 0);
			assertTrue(a < b);
		}
	}
}
