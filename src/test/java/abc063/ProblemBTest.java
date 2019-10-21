package abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("uncopyrightable");
		ProblemB.main(null);
		assertResultIs("yes");
	}

	@Test
	void test_Case2() {
		in.input("different");
		ProblemB.main(null);
		assertResultIs("no");
	}

	@Test
	void test_Case3() {
		in.input("no");
		ProblemB.main(null);
		assertResultIs("yes");
	}
}
