package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem039Test extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2 3\n" + "2 5 4\n" + "2 4 1", "<>=>");
	}

	@Test
	void case2() {
		check("10 10\n" + "1 1 1\n" + "6 7 28\n" + "3 5 4096\n" + "6 10 2000\n" + "1 10 10000\n" + "2 8 2\n"
				+ "10 10 2\n" + "1 2 8000\n" + "6 7 20\n" + "6 8 2048", "<>====>><");
	}
}
