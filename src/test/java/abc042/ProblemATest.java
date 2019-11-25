package abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5 5 7");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("7 7 5");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
