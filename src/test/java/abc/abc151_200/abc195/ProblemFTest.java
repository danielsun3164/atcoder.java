package abc.abc151_200.abc195;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 4", "6");
	}

	@Test
	void case2() {
		check("1 1", "2");
	}

	@Test
	void case3() {
		check("123456789000 123456789050", "2125824");
	}
}
