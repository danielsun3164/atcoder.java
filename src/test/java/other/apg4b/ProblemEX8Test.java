package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX8Test extends TestBase {

	@Test
	void case1() {
		check("1\n" + "80\n" + "5", "400");
	}

	@Test
	void case2() {
		check("2\n" + "umai\n" + "150\n" + "3", "umai!" + LF + "450");
	}

	@Test
	void case3() {
		check("2\n" + "good!\n" + "30\n" + "8", "good!!" + LF + "240");
	}
}
