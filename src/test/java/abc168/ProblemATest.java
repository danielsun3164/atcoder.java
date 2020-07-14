package abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("16");
		ProblemA.main(null);
		assertResultIs("pon");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("hon");
	}

	@Test
	void case3() {
		in.input("183");
		ProblemA.main(null);
		assertResultIs("bon");
	}
}
