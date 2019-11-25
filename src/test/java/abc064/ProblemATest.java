package abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 3 2");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("2 3 4");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
