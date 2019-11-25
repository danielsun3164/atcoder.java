package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("AtCoder Beginner Contest");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void case2() {
		in.input("AtCoder Snuke Contest");
		ProblemA.main(null);
		assertResultIs("ASC");
	}

	@Test
	void case3() {
		in.input("AtCoder X Contest");
		ProblemA.main(null);
		assertResultIs("AXC");
	}
}
