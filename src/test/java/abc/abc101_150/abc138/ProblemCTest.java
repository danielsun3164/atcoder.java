package abc.abc101_150.abc138;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 4", 3.5d);
	}

	@Test
	void case2() {
		check("3\n" + "500 300 200", 375.0d);
	}

	@Test
	void case3() {
		check("5\n" + "138 138 138 138 138", 138.0d);
	}
}
