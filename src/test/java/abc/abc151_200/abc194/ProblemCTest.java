package abc.abc151_200.abc194;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 8 4", "56");
	}

	@Test
	void case2() {
		check("5\n" + "-5 8 9 -4 -3", "950");
	}
}
