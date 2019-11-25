package abc031;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("31 87");
		ProblemA.main(null);
		assertResultIs("2784");
	}

	@Test
	void case2() {
		in.input("101 65");
		ProblemA.main(null);
		assertResultIs("6666");
	}

	@Test
	void case3() {
		in.input("3 3");
		ProblemA.main(null);
		assertResultIs("12");
	}
}
