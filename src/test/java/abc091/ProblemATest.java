package abc091;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("50 100 120");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("500 100 1000");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("19 123 143");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case4() {
		in.input("19 123 142");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
