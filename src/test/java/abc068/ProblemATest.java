package abc068;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("100");
		ProblemA.main(null);
		assertResultIs("ABC100");
	}

	@Test
	void case2() {
		in.input("425");
		ProblemA.main(null);
		assertResultIs("ABC425");
	}

	@Test
	void case3() {
		in.input("999");
		ProblemA.main(null);
		assertResultIs("ABC999");
	}
}
