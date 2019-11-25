package abc026;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1\n" + "1\n" + "1\n" + "1");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("7\n" + "1\n" + "1\n" + "2\n" + "2\n" + "3\n" + "3");
		ProblemC.main(null);
		assertResultIs("7");
	}

	@Test
	void case3() {
		in.input("6\n" + "1\n" + "2\n" + "3\n" + "3\n" + "2");
		ProblemC.main(null);
		assertResultIs("11");
	}

	@Test
	void case4() {
		in.input("10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9");
		ProblemC.main(null);
		assertResultIs("1023");
	}
}
