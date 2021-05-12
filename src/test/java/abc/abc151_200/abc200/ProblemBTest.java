package abc.abc151_200.abc200;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2021 4", "50531");
	}

	@Test
	void case2() {
		check("40000 2", "1");
	}

	@Test
	void case3() {
		check("8691 20", "84875488281");
	}
}
