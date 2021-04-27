package other.language_test_202001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemG_ABC088BTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 1", "2");
	}

	@Test
	void case2() {
		check("3\n" + "2 7 4", "5");
	}

	@Test
	void case3() {
		check("4\n" + "20 18 2 18", "18");
	}
}
