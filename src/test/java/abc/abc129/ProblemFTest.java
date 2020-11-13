package abc.abc129;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 3 4 10007", "5563");
	}

	@Test
	void case2() {
		check("4 8 1 1000000", "891011");
	}

	@Test
	void case3() {
		check("107 10000000000007 1000000000000007 998244353", "39122908");
	}
}
