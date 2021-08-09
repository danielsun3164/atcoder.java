package abc.abc201_250.abc203;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "2 3 4 9", "2 1");
	}

	@Test
	void case2() {
		check("3 3\n" + "2 3 5", "0 3");
	}

	@Test
	void case3() {
		check("9 8\n" + "137 55 56 60 27 28 133 56 55", "1 4");
	}
}
