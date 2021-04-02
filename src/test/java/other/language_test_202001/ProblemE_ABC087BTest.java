package other.language_test_202001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemE_ABC087BTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "2\n" + "2\n" + "100", "2");
	}

	@Test
	void case2() {
		check("5\n" + "1\n" + "0\n" + "150", "0");
	}

	@Test
	void case3() {
		check("30\n" + "40\n" + "50\n" + "6000", "213");
	}
}
