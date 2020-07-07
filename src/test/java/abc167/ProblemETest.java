package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("3 2 1");
		ProblemE.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("100 100 0");
		ProblemE.main(null);
		assertResultIs("73074801");
	}

	@Test
	void case3() {
		in.input("60522 114575 7559");
		ProblemE.main(null);
		assertResultIs("479519525");
	}
}
