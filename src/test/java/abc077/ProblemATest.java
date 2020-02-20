package abc077;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("pot\n" + "top");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("tab\n" + "bet");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("eye\n" + "eel");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
