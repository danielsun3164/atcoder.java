package other.joisc2007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemE_FermatTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5", "9");
	}

	@Test
	void case2() {
		check("19\n" + "21", "487");
	}
}
