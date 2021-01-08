package abc.abc001_050.abc022;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 60 70\n" + "50\n" + "10\n" + "10\n" + "10\n" + "10", "2");
	}

	@Test
	void case2() {
		check("5 50 100\n" + "120\n" + "-10\n" + "-20\n" + "-30\n" + "70", "2");
	}
}
