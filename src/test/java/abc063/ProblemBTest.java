package abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("uncopyrightable");
		ProblemB.main(null);
		assertResultIs("yes");
	}

	@Test
	void case2() {
		in.input("different");
		ProblemB.main(null);
		assertResultIs("no");
	}

	@Test
	void case3() {
		in.input("no");
		ProblemB.main(null);
		assertResultIs("yes");
	}
}
