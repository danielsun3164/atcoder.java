package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX6Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 + 2");
		ProblemEX6.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("5 - 3");
		ProblemEX6.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("10 * 20");
		ProblemEX6.main(null);
		assertResultIs("200");
	}

	@Test
	void test_Case4() {
		in.input("10 / 3");
		ProblemEX6.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case5() {
		in.input("100 / 0");
		ProblemEX6.main(null);
		assertResultIs("error");
	}

	@Test
	void test_Case6() {
		in.input("25 ? 31");
		ProblemEX6.main(null);
		assertResultIs("error");
	}

	@Test
	void test_Case7() {
		in.input("0 + 0");
		ProblemEX6.main(null);
		assertResultIs("0");
	}
}
