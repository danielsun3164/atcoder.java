package abc015;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "0 1 3 8");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "1 4 9 10 15");
		ProblemB.main(null);
		assertResultIs("8");
	}
}
