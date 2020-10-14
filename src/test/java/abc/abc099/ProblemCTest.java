package abc.abc099;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("127", "4");
	}

	@Test
	void case2() {
		check("3", "3");
	}

	@Test
	void case3() {
		check("44852", "16");
	}
}
