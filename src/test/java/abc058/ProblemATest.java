package abc058;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2 4 6");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("2 5 6");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("3 2 1");
		ProblemA.main(null);
		assertResultIs("YES");
	}
}
