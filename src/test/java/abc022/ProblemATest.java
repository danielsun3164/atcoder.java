package abc022;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 60 70\n" + "50\n" + "10\n" + "10\n" + "10\n" + "10");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("5 50 100\n" + "120\n" + "-10\n" + "-20\n" + "-30\n" + "70");
		ProblemA.main(null);
		assertResultIs("2");
	}
}
