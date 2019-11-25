package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("7 5 1");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("2 2 1");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("1 100 97");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case4() {
		in.input("40 98 58");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case5() {
		in.input("77 42 36");
		ProblemB.main(null);
		assertResultIs("NO");
	}
}
