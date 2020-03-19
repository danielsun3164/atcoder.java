package abc088;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1 0 1\n" + "2 1 2\n" + "1 0 1");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("2 2 2\n" + "2 1 2\n" + "2 2 2");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("0 8 8\n" + "0 8 8\n" + "0 8 8");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case4() {
		in.input("1 8 6\n" + "2 9 7\n" + "0 7 7");
		ProblemC.main(null);
		assertResultIs("No");
	}
}
