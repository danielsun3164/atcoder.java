package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX15Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("2\n" + "5 7\n" + "4 10\n" + "9 2");
		ProblemEX15.main(null);
		assertResultIs("1848");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "100 100 100\n" + "100 100 100\n" + "100 100 100");
		ProblemEX15.main(null);
		assertResultIs("27000000");
	}

	@Test
	void test_Case3() {
		in.input("5\n" + "95 20 74 81 10\n" + "100 50 32 84 31\n" + "0 0 0 0 0");
		ProblemEX15.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case4() {
		in.input("2\n" + "10 0\n" + "0 5\n" + "1 1");
		ProblemEX15.main(null);
		assertResultIs("100");
	}
}
