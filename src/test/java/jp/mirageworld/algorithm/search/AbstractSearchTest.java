package jp.mirageworld.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbstractSearchTest {

	List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

	public void searchTest(List<Integer> result, Integer ok, Integer test) {
		System.out.println(result);
		assertEquals(ok, test);
	}

	public void searchTest(List<Integer> result, boolean ok, boolean test) {
		System.out.println(result);
		assertEquals(ok, test);
	}
}
