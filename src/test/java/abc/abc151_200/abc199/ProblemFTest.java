package abc.abc151_200.abc199;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2 1\n" + "3 1 5\n" + "1 2\n" + "1 3", "3" + LF + "500000005" + LF + "500000008");
	}

	@Test
	void case2() {
		check("3 2 2\n" + "12 48 36\n" + "1 2\n" + "1 3", "750000036" + LF + "36" + LF + "250000031");
	}

	@Test
	void case3() {
		check("4 5 1000\n" + "578 173 489 910\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 1\n" + "1 3",
				"201113830" + LF + "45921509" + LF + "67803140" + LF + "685163678");
	}
}
