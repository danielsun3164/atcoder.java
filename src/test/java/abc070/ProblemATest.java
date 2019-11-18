package abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("575");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("123");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void test_Case3() {
		in.input("812");
		ProblemA.main(null);
		assertResultIs("No");
	}
}
