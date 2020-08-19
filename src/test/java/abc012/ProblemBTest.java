package abc012;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3661", "01:01:01");
	}

	@Test
	void case2() {
		check("86399", "23:59:59");
	}
}
