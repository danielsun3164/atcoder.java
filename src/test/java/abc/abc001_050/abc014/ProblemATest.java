package abc.abc001_050.abc014;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "3", "2");
	}

	@Test
	void case2() {
		check("5\n" + "5", "0");
	}

	@Test
	void case3() {
		check("1\n" + "100", "99");
	}

	@Test
	void case4() {
		check("25\n" + "12", "11");
	}
}
