package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3 4");
		ProblemA.main(null);
		assertResultIs("52");
	}

	@Test
	void test_Case2() {
		in.input("3 4 2");
		ProblemA.main(null);
		assertResultIs("52");
	}

	@Test
	void test_Case3() {
		in.input("100 100 100");
		ProblemA.main(null);
		assertResultIs("60000");
	}

	@Test
	void test_Case4() {
		in.input("1 1 1");
		ProblemA.main(null);
		assertResultIs("6");
	}
}
