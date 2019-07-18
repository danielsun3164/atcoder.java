package abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1000 8\n" + "1 3 4 5 6 7 8 9");
		ProblemC.main(null);
		assertResultIs("2000");
	}

	@Test
	void test_Case2() {
		in.input("9999 1\n" + "0");
		ProblemC.main(null);
		assertResultIs("9999");
	}
}
