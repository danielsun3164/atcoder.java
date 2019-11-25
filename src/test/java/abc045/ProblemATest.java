package abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "4\n" + "2");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("4\n" + "4\n" + "4");
		ProblemA.main(null);
		assertResultIs("16");
	}
}
