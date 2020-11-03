package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX10Test extends TestBase {

	@Test
	void case1() {
		check("5 9", "A:]]]]]" + LF + "B:]]]]]]]]]");
	}

	@Test
	void case2() {
		check("0 20", "A:" + LF + "B:]]]]]]]]]]]]]]]]]]]]");
	}
}
