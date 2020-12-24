package abc.abc151_200.abc182;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 9\n" + "1 5 10", "3");
	}

	@Test
	void case2() {
		check("5 198\n" + "1 5 10 50 100", "5");
	}

	@Test
	void case3() {
		check("4 44\n" + "1 4 20 100", "4");
	}

	@Test
	void case4() {
		check("9 11837029798\n"
				+ "1 942454037 2827362111 19791534777 257289952101 771869856303 3859349281515 30874794252120 216123559764840",
				"21");
	}
}
