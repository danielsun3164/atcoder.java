package abc.abc151_200.abc161;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "5 4 2 1", "Yes");
	}

	@Test
	void case2() {
		check("3 2\n" + "380 19 1", "No");
	}

	@Test
	void case3() {
		check("12 3\n" + "4 56 78 901 2 345 67 890 123 45 6 789", "Yes");
	}
}
