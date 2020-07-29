package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("3 5 2\n" + "3 2 3 4\n" + ".....\n" + ".@..@\n" + "..@..");
		ProblemF.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("1 6 4\n" + "1 1 1 6\n" + "......");
		ProblemF.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("3 3 1\n" + "2 1 2 3\n" + ".@.\n" + ".@.\n" + ".@.");
		ProblemF.main(null);
		assertResultIs("-1");
	}
}
