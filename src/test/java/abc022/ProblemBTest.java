package abc022;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "1\n" + "2\n" + "3\n" + "2\n" + "1");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("11\n" + "3\n" + "1\n" + "4\n" + "1\n" + "5\n" + "9\n" + "2\n" + "6\n" + "5\n" + "3\n" + "5");
		ProblemB.main(null);
		assertResultIs("4");
	}
}
