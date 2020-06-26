package jp.mirageworld.algorithm.shuffle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbstractShuffleTest {

	List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

	public void shuffleTest(List<Integer> result) {
		System.out.println(result);
		assertEquals(list.size(), result.size());
	}
}
