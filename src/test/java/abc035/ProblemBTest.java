package abc035;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("UL?\n" + "1");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("UD?\n" + "1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case3() {
		in.input("UUUU?DDR?LLLL\n" + "1");
		ProblemB.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case4() {
		in.input("UULL?\n" + "2");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
