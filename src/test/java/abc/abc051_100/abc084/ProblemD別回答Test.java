package abc.abc051_100.abc084;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("1\n" + "3 7", "2");
	}

	@Test
	void case2() {
		check("4\n" + "13 13\n" + "7 11\n" + "7 11\n" + "2017 2017", "1" + LF + "0" + LF + "0" + LF + "1");
	}

	@Test
	void case3() {
		check("6\n" + "1 53\n" + "13 91\n" + "37 55\n" + "19 51\n" + "73 91\n" + "13 49",
				"4" + LF + "4" + LF + "1" + LF + "1" + LF + "1" + LF + "2");
	}
}
