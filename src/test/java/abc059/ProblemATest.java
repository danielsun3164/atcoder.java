package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("atcoder beginner contest");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void case2() {
		in.input("resident register number");
		ProblemA.main(null);
		assertResultIs("RRN");
	}

	@Test
	void case3() {
		in.input("k nearest neighbor");
		ProblemA.main(null);
		assertResultIs("KNN");
	}

	@Test
	void case4() {
		in.input("async layered coding");
		ProblemA.main(null);
		assertResultIs("ALC");
	}
}
