package other.apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX9Test extends TestBase {

	@Test
	void case1() {
		check("1 2 3", "2" + LF + "10" + LF + "100" + LF + "99");
	}

	@Test
	void case2() {
		check("3 2 5", "4" + LF + "28" + LF + "784" + LF + "783");
	}
}
