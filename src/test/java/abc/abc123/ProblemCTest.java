package abc.abc123;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "2\n" + "4\n" + "3\n" + "5", "7");
	}

	@Test
	void case2() {
		check("10\n" + "123\n" + "123\n" + "123\n" + "123\n" + "123", "5");
	}

	@Test
	void case3() {
		check("10000000007\n" + "2\n" + "3\n" + "5\n" + "7\n" + "11", "5000000008");
	}
}
