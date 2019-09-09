package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "IIDID");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("7\n" + "DDIDDII");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
