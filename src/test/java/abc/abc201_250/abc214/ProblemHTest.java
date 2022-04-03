package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("5 5 2\n" + "1 2\n" + "2 3\n" + "3 2\n" + "1 4\n" + "1 5\n" + "1 4 5 2 8", "18");
	}

	@Test
	void case2() {
		check("3 1 10\n" + "2 3\n" + "1 100 100", "1");
	}
}
