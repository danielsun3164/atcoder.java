package other.joi2006ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "122244", "113224");
	}

	@Test
	void case2() {
		check("1\n" + "44444444444", "114");
	}

	@Test
	void case3() {
		check("5\n" + "11", "13112221");
	}
}
