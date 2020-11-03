package abc.abc025;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("0 15 0\n" + "0 0 25\n" + "20 10\n" + "0 0\n" + "25 0", "15" + LF + "80");
	}

	@Test
	void case2() {
		check("18 22 15\n" + "11 16 17\n" + "4 25\n" + "22 15\n" + "10 4", "72" + LF + "107");
	}
}
