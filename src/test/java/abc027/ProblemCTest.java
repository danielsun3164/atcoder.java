package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}

	@Test
	void test_Case2() {
		in.input("5");
		ProblemC.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void test_Case3() {
		in.input("7");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}

	@Test
	void test_Case4() {
		in.input("10");
		ProblemC.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void test_Case5() {
		in.input("123456789123456789");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}
}
