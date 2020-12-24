package abc.abc151_200.abc171;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "50 100 80 120 80", "210");
	}

	@Test
	void case2() {
		check("1 1\n" + "1000", "1000");
	}
}
