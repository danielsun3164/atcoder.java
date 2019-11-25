package abc006;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void case2() {
		in.input("9");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case3() {
		in.input("3");
		ProblemA.main(null);
		assertResultIs("YES");
	}
}
