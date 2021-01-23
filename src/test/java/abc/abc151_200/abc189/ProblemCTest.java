package abc.abc151_200.abc189;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "2 4 4 9 4 9", "20");
	}

	@Test
	void case2() {
		check("6\n" + "200 4 4 9 4 9", "200");
	}
}
