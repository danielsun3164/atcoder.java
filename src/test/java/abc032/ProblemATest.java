package abc032;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "3\n" + "8");
		ProblemA.main(null);
		assertResultIs("12");
	}

	@Test
	void case2() {
		in.input("2\n" + "2\n" + "2");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("12\n" + "8\n" + "25");
		ProblemA.main(null);
		assertResultIs("48");
	}
}
