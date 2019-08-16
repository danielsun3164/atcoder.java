package abc047;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("BBBWW");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("WWWWWW");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("WBWBWBWBWB");
		ProblemC.main(null);
		assertResultIs("9");
	}
}
