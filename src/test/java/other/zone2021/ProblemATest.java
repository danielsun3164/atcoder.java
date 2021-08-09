package other.zone2021;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("abcdZONefghi", "1");
	}

	@Test
	void case2() {
		check("ZONeZONeZONe", "3");
	}

	@Test
	void case3() {
		check("helloAtZoner", "0");
	}
}
