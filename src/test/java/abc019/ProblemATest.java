package abc019;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2 3 4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("5 100 5");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("3 3 3");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case4() {
		in.input("3 3 4");
		ProblemA.main(null);
		assertResultIs("3");
	}
}
