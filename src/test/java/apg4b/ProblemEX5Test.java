package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX5Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 2");
		ProblemEX5.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("100 99");
		ProblemEX5.main(null);
		assertResultIs("199");
	}
}
