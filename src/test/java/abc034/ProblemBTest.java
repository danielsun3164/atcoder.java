package abc034;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("100");
		ProblemB.main(null);
		assertResultIs("99");
	}

	@Test
	void test_Case2() {
		in.input("123456789");
		ProblemB.main(null);
		assertResultIs("123456790");
	}
}
