package abc057;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 2\n" + "2 0\n" + "0 0\n" + "-1 0\n" + "1 0");
		ProblemB.main(null);
		assertResultIs("2" + LF + "1");
	}

	@Test
	void test_Case2() {
		in.input("3 4\n" + "10 10\n" + "-10 -10\n" + "3 3\n" + "1 2\n" + "2 3\n" + "3 5\n" + "3 5");
		ProblemB.main(null);
		assertResultIs("3" + LF + "1" + LF + "2");
	}

	@Test
	void test_Case3() {
		in.input("5 5\n" + "-100000000 -100000000\n" + "-100000000 100000000\n" + "100000000 -100000000\n"
				+ "100000000 100000000\n" + "0 0\n" + "0 0\n" + "100000000 100000000\n" + "100000000 -100000000\n"
				+ "-100000000 100000000\n" + "-100000000 -100000000");
		ProblemB.main(null);
		assertResultIs("5" + LF + "4" + LF + "3" + LF + "2" + LF + "1");
	}
}
