package abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("abcdef\n" + "2\n" + "3 5\n" + "1 4");
		ProblemB.main(null);
		assertResultIs("debacf");
	}

	@Test
	void test_Case2() {
		in.input("redcoat\n" + "3\n" + "1 7\n" + "1 2\n" + "3 4");
		ProblemB.main(null);
		assertResultIs("atcoder");
	}
}
