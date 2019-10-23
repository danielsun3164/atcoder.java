package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "3\n" + "1\n" + "2");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "3\n" + "4\n" + "1\n" + "2");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case3() {
		in.input("5\n" + "3\n" + "3\n" + "4\n" + "2\n" + "4");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
