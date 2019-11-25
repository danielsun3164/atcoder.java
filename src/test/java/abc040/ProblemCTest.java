package abc040;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "100 150 130 120");
		ProblemC.main(null);
		assertResultIs("40");
	}

	@Test
	void case2() {
		in.input("4\n" + "100 125 80 110");
		ProblemC.main(null);
		assertResultIs("40");
	}

	@Test
	void case3() {
		in.input("9\n" + "314 159 265 358 979 323 846 264 338");
		ProblemC.main(null);
		assertResultIs("310");
	}
}
