package abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 4\n" + "1 1\n" + "2 2\n" + "3 3");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("10 500000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n" + "1 100000\n"
				+ "100000 100000\n" + "100000 100000\n" + "100000 100000\n" + "100000 100000\n" + "100000 100000");
		ProblemC.main(null);
		assertResultIs("1");
	}
}
