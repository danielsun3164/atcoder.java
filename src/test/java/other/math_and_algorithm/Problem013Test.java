package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem013Test extends TestBase {

	@Test
	void case1() {
		check("12", "1" + LF + "2" + LF + "3" + LF + "4" + LF + "6" + LF + "12");
	}

	@Test
	void case2() {
		check("827847039317", "1" + LF + "909859" + LF + "909863" + LF + "827847039317");
	}
}
