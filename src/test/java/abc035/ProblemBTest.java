package abc035;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("UL?\n" + "1");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("UD?\n" + "1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("UUUU?DDR?LLLL\n" + "1");
		ProblemB.main(null);
		assertResultIs("7");
	}

	@Test
	void case4() {
		in.input("UULL?\n" + "2");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
