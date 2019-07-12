package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("981506241");
		ProblemB.main(null);
		assertResultIs("177");
	}

	@Test
	void test_Case3() {
		in.input("390625");
		ProblemB.main(null);
		assertResultIs("25");
	}
}
