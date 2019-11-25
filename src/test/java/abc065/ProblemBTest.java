package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "3\n" + "1\n" + "2");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("4\n" + "3\n" + "4\n" + "1\n" + "2");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("5\n" + "3\n" + "3\n" + "4\n" + "2\n" + "4");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
