package abc068;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("7");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("32");
		ProblemB.main(null);
		assertResultIs("32");
	}

	@Test
	void case3() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case4() {
		in.input("100");
		ProblemB.main(null);
		assertResultIs("64");
	}
}
