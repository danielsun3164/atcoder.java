package abc040;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 2");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("6 4");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("90 30");
		ProblemA.main(null);
		assertResultIs("29");
	}
}
