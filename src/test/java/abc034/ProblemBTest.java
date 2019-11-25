package abc034;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("100");
		ProblemB.main(null);
		assertResultIs("99");
	}

	@Test
	void case2() {
		in.input("123456789");
		ProblemB.main(null);
		assertResultIs("123456790");
	}
}
