package abc.abc151_200.abc190;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 9 9\n" + "5 5\n" + "15 5\n" + "5 15\n" + "15 15", "Yes");
	}

	@Test
	void case2() {
		check("3 691 273\n" + "691 997\n" + "593 273\n" + "691 273", "No");
	}

	@Test
	void case3() {
		check("7 100 100\n" + "10 11\n" + "12 67\n" + "192 79\n" + "154 197\n" + "142 158\n" + "20 25\n" + "17 108",
				"Yes");
	}
}
