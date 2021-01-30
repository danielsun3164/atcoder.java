package abc.abc151_200.abc190;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemC別回答Test extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2\n" + "1 3\n" + "2 4\n" + "3 4\n" + "3\n" + "1 2\n" + "1 3\n" + "2 3", "2");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 2\n" + "1 3\n" + "2 4\n" + "3 4\n" + "4\n" + "3 4\n" + "1 2\n" + "2 4\n" + "2 4", "4");
	}

	@Test
	void case3() {
		check("6 12\n" + "2 3\n" + "4 6\n" + "1 2\n" + "4 5\n" + "2 6\n" + "1 5\n" + "4 5\n" + "1 3\n" + "1 2\n"
				+ "2 6\n" + "2 3\n" + "2 5\n" + "5\n" + "3 5\n" + "1 4\n" + "2 6\n" + "4 6\n" + "5 6", "9");
	}
}
