package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX5Test extends TestBase {

	@Test
	void case1() {
		in.input("1 2");
		ProblemEX5.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("100 99");
		ProblemEX5.main(null);
		assertResultIs("199");
	}
}
