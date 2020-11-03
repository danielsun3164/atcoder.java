package abc.abc181;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2 3 4 7\n" + "1 3 8", "3");
	}

	@Test
	void case2() {
		check("7 7\n" + "31 60 84 23 16 13 32\n" + "96 80 73 76 87 57 29", "34");
	}

	@Test
	void case3() {
		check("15 10\n" + "554 525 541 814 661 279 668 360 382 175 833 783 688 793 736\n"
				+ "496 732 455 306 189 207 976 73 567 759", "239");
	}
}
