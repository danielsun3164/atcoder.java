package abc.abc016;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("-2 0 2 0\n" + "4\n" + "1 1\n" + "-1 1\n" + "-1 -1\n" + "1 -1", "2");
	}

	@Test
	void case2() {
		check("-3 1 3 1\n" + "8\n" + "2 2\n" + "1 2\n" + "1 0\n" + "-1 0\n" + "-1 2\n" + "-2 2\n" + "-2 -1\n" + "2 -1",
				"3");
	}
}
