package abc006;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("7");
		ProblemB.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case2() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("100000");
		ProblemB.main(null);
		assertResultIs("7927");
	}
}
