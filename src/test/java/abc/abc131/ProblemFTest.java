package abc.abc131;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 1\n" + "5 1\n" + "5 5", "1");
	}

	@Test
	void case2() {
		check("2\n" + "10 10\n" + "20 20", "0");
	}

	@Test
	void case3() {
		check("9\n" + "1 1\n" + "2 1\n" + "3 1\n" + "4 1\n" + "5 1\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5", "16");
	}
}
