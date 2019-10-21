package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 3");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("2 4");
		ProblemA.main(null);
		assertResultIs("No");
	}
}
