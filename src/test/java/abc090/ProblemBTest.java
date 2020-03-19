package abc090;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("11009 11332");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("31415 92653");
		ProblemB.main(null);
		assertResultIs("612");
	}
}
