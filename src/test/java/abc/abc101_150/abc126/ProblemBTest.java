package abc.abc101_150.abc126;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1905", "YYMM");
	}

	@Test
	void case2() {
		check("0112", "AMBIGUOUS");
	}

	@Test
	void case3() {
		check("1700", "NA");
	}
}
