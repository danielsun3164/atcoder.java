package abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("10 11");
		ProblemA.main(null);
		assertResultIs("11");
	}

	@Test
	void case2() {
		in.input("100000000 10000000");
		ProblemA.main(null);
		assertResultIs("100000000");
	}
}
