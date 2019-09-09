package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("7");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("149696127901");
		ProblemC.main(null);
		assertResultIs("27217477801");
	}
}
