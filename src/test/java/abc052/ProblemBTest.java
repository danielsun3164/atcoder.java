package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "IIDID", "2");
	}

	@Test
	void case2() {
		check("7\n" + "DDIDDII", "0");
	}
}
