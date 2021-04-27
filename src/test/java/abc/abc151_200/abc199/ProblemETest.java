package abc.abc151_200.abc199;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "2 2 1", "4");
	}

	@Test
	void case2() {
		check("5 2\n" + "3 3 2\n" + "4 4 3", "90");
	}

	@Test
	void case3() {
		check("18 0", "6402373705728000");
	}
}
