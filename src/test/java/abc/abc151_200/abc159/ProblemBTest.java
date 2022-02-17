package abc.abc151_200.abc159;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("akasaka", "Yes");
	}

	@Test
	void case2() {
		check("level", "No");
	}

	@Test
	void case3() {
		check("atcoder", "No");
	}
}
