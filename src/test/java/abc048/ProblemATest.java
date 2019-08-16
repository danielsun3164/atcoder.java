package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("AtCoder Beginner Contest");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void test_Case2() {
		in.input("AtCoder Snuke Contest");
		ProblemA.main(null);
		assertResultIs("ASC");
	}

	@Test
	void test_Case3() {
		in.input("AtCoder X Contest");
		ProblemA.main(null);
		assertResultIs("AXC");
	}
}
