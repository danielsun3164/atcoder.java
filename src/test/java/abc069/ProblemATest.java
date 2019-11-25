package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 4");
		ProblemA.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("2 2");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
