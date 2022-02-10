package abc.abc151_200.abc155;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 7 5", "Yes");
	}

	@Test
	void case2() {
		check("4 4 4", "No");
	}

	@Test
	void case3() {
		check("4 9 6", "No");
	}

	@Test
	void case4() {
		check("3 3 4", "Yes");
	}
}
