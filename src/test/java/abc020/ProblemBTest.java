package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1 23");
		ProblemB.main(null);
		assertResultIs("246");
	}

	@Test
	void case2() {
		in.input("999 999");
		ProblemB.main(null);
		assertResultIs("1999998");
	}
}
