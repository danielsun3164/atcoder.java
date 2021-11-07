package abc.abc201_250.abc210;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7 3\n" + "1 2 1 2 3 3 1", "3");
	}

	@Test
	void case2() {
		check("5 5\n" + "4 4 4 4 4", "1");
	}

	@Test
	void case3() {
		check("10 6\n"
				+ "304621362 506696497 304621362 506696497 834022578 304621362 414720753 304621362 304621362 414720753",
				"4");
	}
}
