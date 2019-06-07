package abc013;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "6");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("6\n" + "4");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("8\n" + "1");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
