package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1 1 8 2 2 4\n" + "1\n" + "4 5");
		ProblemC.main(null);
		assertResultIs("NO");
	}

	@Test
	void case2() {
		in.input("1 1 8 2 2 6\n" + "1\n" + "4 5");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void case3() {
		in.input("1 1 8 2 2 5\n" + "1\n" + "4 5");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void case4() {
		in.input("7 7 1 1 3 4\n" + "3\n" + "8 1\n" + "1 7\n" + "9 9");
		ProblemC.main(null);
		assertResultIs("YES");
	}
}
