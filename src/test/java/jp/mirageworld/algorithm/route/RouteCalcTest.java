package jp.mirageworld.algorithm.route;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RouteCalcTest {

	@Test
	public void testCalc() {
		String[][] m = {
				{ "0", "s", "0", "1" },
				{ "0", "0", "1", "0" },
				{ "0", "1", "1", "0" },
				{ "0", "0", "1", "g" },
				{ "0", "0", "0", "0" },
		};

		RouteCalc rc = new RouteCalc();
		assertEquals(rc.calc(m), 9);
	}

}
