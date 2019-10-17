package abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 3 2");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("6 5 4");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void test_Case3() {
		in.input("2 2 2");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
