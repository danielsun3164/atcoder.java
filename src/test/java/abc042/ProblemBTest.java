package abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "dxx\n" + "axx\n" + "cxx", "axxcxxdxx");
	}
}
