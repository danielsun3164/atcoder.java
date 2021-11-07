package abc.abc201_250.abc210;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 5\n" + "10 9\n" + "4 8", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + "10 100\n" + "1000 10000", "No");
	}
}
