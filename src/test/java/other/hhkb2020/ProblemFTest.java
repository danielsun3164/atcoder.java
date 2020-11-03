package other.hhkb2020;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "1 2", "3");
	}

	@Test
	void case2() {
		check("2\n" + "1 2\n" + "1 2", "10");
	}

	@Test
	void case3() {
		check("2\n" + "1 2\n" + "2 4", "36");
	}

	@Test
	void case4() {
		check("5\n" + "40 96\n" + "81 92\n" + "16 384\n" + "32 768\n" + "65 536", "52776507");
	}
}
