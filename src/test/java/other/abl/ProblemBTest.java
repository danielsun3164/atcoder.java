package other.abl;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10 30 20 40", "Yes");
	}

	@Test
	void case2() {
		check("10 20 30 40", "No");
	}
}
