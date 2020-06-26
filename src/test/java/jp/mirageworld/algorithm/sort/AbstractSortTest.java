package jp.mirageworld.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbstractSortTest {

	List<Integer> list = IntStream.of(8, 4, 3, 7, 6, 5, 2, 1).boxed().collect(Collectors.toList());

	public void sortTest(List<Integer> result) {

		System.out.println(result);

		for (int i = 1; i < result.size(); i++) {
			int a = result.get(1 - 1);
			int b = result.get(1 - 0);
			assertTrue(a < b);
		}
	}
}
