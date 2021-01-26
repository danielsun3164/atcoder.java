package abc.abc151_200.abc189;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "AND\n" + "OR", "5");
	}

	@Test
	void case2() {
		check("5\n" + "OR\n" + "OR\n" + "OR\n" + "OR\n" + "OR", "63");
	}
}
