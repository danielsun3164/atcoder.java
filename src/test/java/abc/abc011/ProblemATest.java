package abc.abc011;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1", "2");
	}

	@Test
	void case2() {
		check("12", "1");
	}
}
