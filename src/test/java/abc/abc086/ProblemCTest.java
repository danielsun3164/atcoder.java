package abc.abc086;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 1 2\n" + "6 1 1", "Yes");
	}

	@Test
	void case2() {
		check("1\n" + "2 100 100", "No");
	}

	@Test
	void case3() {
		check("2\n" + "5 1 1\n" + "100 1 1", "No");
	}
}
