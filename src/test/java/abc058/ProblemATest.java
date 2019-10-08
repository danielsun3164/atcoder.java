package abc058;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 4 6");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("2 5 6");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void test_Case3() {
		in.input("3 2 1");
		ProblemA.main(null);
		assertResultIs("YES");
	}
}
