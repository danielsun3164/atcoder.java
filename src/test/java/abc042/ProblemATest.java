package abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 5 7");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("7 7 5");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
