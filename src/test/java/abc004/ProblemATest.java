package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1000");
		ProblemA.main(null);
		assertResultIs("2000");
	}

	@Test
	void case2() {
		in.input("1000000");
		ProblemA.main(null);
		assertResultIs("2000000");
	}

	@Test
	void case3() {
		in.input("0");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
