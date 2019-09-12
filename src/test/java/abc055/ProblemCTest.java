package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 6");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("12345 678901");
		ProblemC.main(null);
		assertResultIs("175897");
	}
}
