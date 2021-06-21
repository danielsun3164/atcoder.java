package abc.abc201_250.abc204;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "7");
	}

	@Test
	void case2() {
		check("3 3", "131");
	}

	@Test
	void case3() {
		check("5 100", "379944232");
	}
}
