package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbstractSortTest {

	List<Integer> list = IntStream.of(8, 4, 3, 7, 6, 5, 2, 1).boxed().collect(Collectors.toList());

	public void sortTest(List<Integer> result) {

		System.out.println(result);

		for (int i = 0; i < result.size() - 1; i++) {
			int j = i + 1;
			int a = result.get(i);
			int b = result.get(j);
			assertTrue(a < b, "%d < %d".formatted(a, b));
		}
	}
}
