package abc.abc001_050.abc027;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("M+MM-M", "2");
	}

	@Test
	void case2() {
		check("MMM+M", "1");
	}

	@Test
	void case3() {
		check("MMM+--MMM", "3");
	}

	@Test
	void case4() {
		check("+", "0");
	}
}
