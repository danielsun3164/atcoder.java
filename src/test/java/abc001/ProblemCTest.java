package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2750 628");
		ProblemC.main(null);
		assertResultIs("W 5");
	}

	@Test
	void case2() {
		in.input("161 8");
		ProblemC.main(null);
		assertResultIs("C 0");
	}

	@Test
	void case3() {
		in.input("3263 15");
		ProblemC.main(null);
		assertResultIs("NNW 1");
	}

	@Test
	void case4() {
		in.input("1462 1959");
		ProblemC.main(null);
		assertResultIs("SE 12");
	}

	@Test
	void case5() {
		in.input("1687 1029");
		ProblemC.main(null);
		assertResultIs("SSE 8");
	}

	@Test
	void case6() {
		in.input("2587 644");
		ProblemC.main(null);
		assertResultIs("WSW 5");
	}

	@Test
	void case7() {
		in.input("113 201");
		ProblemC.main(null);
		assertResultIs("NNE 3");
	}

	@Test
	void case8() {
		in.input("2048 16");
		ProblemC.main(null);
		assertResultIs("SSW 1");
	}
}
