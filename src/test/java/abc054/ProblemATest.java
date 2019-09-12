package abc054;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("8 6");
		ProblemA.main(null);
		assertResultIs("Alice");
	}

	@Test
	void test_Case2() {
		in.input("1 1");
		ProblemA.main(null);
		assertResultIs("Draw");
	}

	@Test
	void test_Case3() {
		in.input("13 1");
		ProblemA.main(null);
		assertResultIs("Bob");
	}
}
