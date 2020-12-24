package abc.abc001_050.abc042;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "dxx\n" + "axx\n" + "cxx", "axxcxxdxx");
	}
}
