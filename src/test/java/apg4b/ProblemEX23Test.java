package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX23Test extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1 4 4 2 3");
		ProblemEX23.main(null);
		assertResultIs("4 2");
	}

	@Test
	void case2() {
		in.input("6\n" + "3 2 3 1 3 2");
		ProblemEX23.main(null);
		assertResultIs("3 3");
	}

	@Test
	void case3() {
		in.input("1\n" + "1000000000");
		ProblemEX23.main(null);
		assertResultIs("1000000000 1");
	}
}
