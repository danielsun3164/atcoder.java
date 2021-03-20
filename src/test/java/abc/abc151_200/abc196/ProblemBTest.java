package abc.abc151_200.abc196;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5.90", "5");
	}

	@Test
	void case2() {
		check("0", "0");
	}

	@Test
	void case3() {
		check("84939825309432908832902189.9092309409809091329", "84939825309432908832902189");
	}
}
