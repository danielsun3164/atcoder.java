package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}

	@Test
	void case2() {
		in.input("5");
		ProblemC.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void case3() {
		in.input("7");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}

	@Test
	void case4() {
		in.input("10");
		ProblemC.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void case5() {
		in.input("123456789123456789");
		ProblemC.main(null);
		assertResultIs("Aoki");
	}
}
