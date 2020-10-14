package abc.abc178;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "2");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("869121", "2511445");
	}
}
