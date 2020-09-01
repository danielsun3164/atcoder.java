package abc.abc092;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("600\n" + "300\n" + "220\n" + "420", "520");
	}

	@Test
	void case2() {
		check("555\n" + "555\n" + "400\n" + "200", "755");
	}

	@Test
	void case3() {
		check("549\n" + "817\n" + "715\n" + "603", "1152");
	}
}
