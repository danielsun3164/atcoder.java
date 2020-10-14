package abc.abc115;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "10\n" + "15\n" + "11\n" + "14\n" + "12", "2");
	}

	@Test
	void case2() {
		check("5 3\n" + "5\n" + "7\n" + "5\n" + "7\n" + "7", "0");
	}
}
