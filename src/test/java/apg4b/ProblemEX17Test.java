package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX17Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 400\n" + "100 100 130\n" + "270 300 250");
		ProblemEX17.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("10 600\n" + "70 110 90 120 90 20 260 150 220 150\n" + "170 100 250 350 60 280 450 460 20 220");
		ProblemEX17.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("3 200\n" + "100 100 100\n" + "100 100 100");
		ProblemEX17.main(null);
		assertResultIs("9");
	}

	@Test
	void test_Case4() {
		in.input("1 0\n" + "100\n" + "200");
		ProblemEX17.main(null);
		assertResultIs("0");
	}
}
