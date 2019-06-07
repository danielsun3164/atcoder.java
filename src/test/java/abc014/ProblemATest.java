package abc014;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("7\n" + "3");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "5");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("1\n" + "100");
		ProblemA.main(null);
		assertResultIs("99");
	}

	@Test
	void test_Case4() {
		in.input("25\n" + "12");
		ProblemA.main(null);
		assertResultIs("11");
	}
}
