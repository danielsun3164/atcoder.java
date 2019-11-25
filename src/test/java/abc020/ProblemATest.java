package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("chokudai");
	}
}
