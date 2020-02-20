package abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("13 3 1");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("12 3 1");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("100000 1 1");
		ProblemB.main(null);
		assertResultIs("49999");
	}

	@Test
	void case4() {
		in.input("64146 123 456");
		ProblemB.main(null);
		assertResultIs("110");
	}

	@Test
	void case5() {
		in.input("64145 123 456");
		ProblemB.main(null);
		assertResultIs("109");
	}
}
