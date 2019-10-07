package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX25Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "intersection");
		ProblemEX25.main(null);
		assertResultIs("1 2");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "union_set");
		ProblemEX25.main(null);
		assertResultIs("0 1 2 3");
	}

	@Test
	void test_Case3() {
		in.input("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "symmetric_diff");
		ProblemEX25.main(null);
		assertResultIs("0 3");
	}

	@Test
	void test_Case4() {
		in.input("3\n" + "0 1 2\n" + "3\n" + "1 2 3\n" + "subtract 2");
		ProblemEX25.main(null);
		assertResultIs("0 1");
	}

	@Test
	void test_Case5() {
		in.input("3\n" + "0 1 49\n" + "3\n" + "1 2 3\n" + "increment");
		ProblemEX25.main(null);
		assertResultIs("0 1 2");
	}

	@Test
	void test_Case6() {
		in.input("3\n" + "0 1 49\n" + "3\n" + "1 2 3\n" + "decrement");
		ProblemEX25.main(null);
		assertResultIs("0 48 49");
	}
}
