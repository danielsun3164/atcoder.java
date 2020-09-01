package abc.abc090;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ant\n" + "obe\n" + "rec", "abc");
	}

	@Test
	void case2() {
		check("edu\n" + "cat\n" + "ion", "ean");
	}
}
