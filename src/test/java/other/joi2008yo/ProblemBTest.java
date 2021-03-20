package other.joi2008yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("JOIJOI", "2" + LF + "0");
	}

	@Test
	void case2() {
		check("JOIOIOIOI", "1" + LF + "3");
	}

	@Test
	void case3() {
		check("JOIOIJOINXNXJIOIOIOJ", "2" + LF + "3");
	}
}
