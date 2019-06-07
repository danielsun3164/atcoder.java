package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1000");
		ProblemA.main(null);
		assertResultIs("2000");
	}

	@Test
	void test_Case2() {
		in.input("1000000");
		ProblemA.main(null);
		assertResultIs("2000000");
	}

	@Test
	void test_Case3() {
		in.input("0");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
