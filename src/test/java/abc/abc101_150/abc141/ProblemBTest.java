package abc.abc101_150.abc141;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("RUDLUDR", "Yes");
	}

	@Test
	void case2() {
		check("DULL", "No");
	}

	@Test
	void case3() {
		check("UUUUUUUUUUUUUUU", "Yes");
	}

	@Test
	void case4() {
		check("ULURU", "No");
	}

	@Test
	void case5() {
		check("RDULULDURURLRDULRLR", "Yes");
	}
}
