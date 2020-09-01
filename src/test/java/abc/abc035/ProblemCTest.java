package abc.abc035;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 4\n" + "1 4\n" + "2 5\n" + "3 3\n" + "1 5", "01010");
	}

	@Test
	void case2() {
		check("20 8\n" + "1 8\n" + "4 13\n" + "8 8\n" + "3 18\n" + "5 20\n" + "19 20\n" + "2 7\n" + "4 9",
				"10110000011110000000");
	}
}
