package abc082;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1 3");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("7 4");
		ProblemA.main(null);
		assertResultIs("6");
	}

	@Test
	void case3() {
		in.input("5 5");
		ProblemA.main(null);
		assertResultIs("5");
	}
}
