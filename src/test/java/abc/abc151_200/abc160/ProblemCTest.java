package abc.abc151_200.abc160;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("20 3\n" + "5 10 15", "10");
	}

	@Test
	void case2() {
		check("20 3\n" + "0 5 15", "10");
	}
}
