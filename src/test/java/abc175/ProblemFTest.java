package abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "ba 3\n" + "abc 4\n" + "cbaa 5");
		ProblemF.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("2\n" + "abcab 5\n" + "cba 3");
		ProblemF.main(null);
		assertResultIs("11");
	}

	@Test
	void case3() {
		in.input("2\n" + "abc 1\n" + "ab 2");
		ProblemF.main(null);
		assertResultIs("-1");
	}

	@Test
	void case4() {
		in.input("3\n" + "ba 3\n" + "abc 4\n" + "cbaa 5");
		ProblemF.main(null);
		assertResultIs("7");
	}
}
