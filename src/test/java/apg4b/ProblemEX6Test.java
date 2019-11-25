package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX6Test extends TestBase {

	@Test
	void case1() {
		in.input("1 + 2");
		ProblemEX6.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("5 - 3");
		ProblemEX6.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("10 * 20");
		ProblemEX6.main(null);
		assertResultIs("200");
	}

	@Test
	void case4() {
		in.input("10 / 3");
		ProblemEX6.main(null);
		assertResultIs("3");
	}

	@Test
	void case5() {
		in.input("100 / 0");
		ProblemEX6.main(null);
		assertResultIs("error");
	}

	@Test
	void case6() {
		in.input("25 ? 31");
		ProblemEX6.main(null);
		assertResultIs("error");
	}

	@Test
	void case7() {
		in.input("0 + 0");
		ProblemEX6.main(null);
		assertResultIs("0");
	}
}
