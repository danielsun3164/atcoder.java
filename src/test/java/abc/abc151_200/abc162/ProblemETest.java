package abc.abc151_200.abc162;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2", "9");
	}

	@Test
	void case2() {
		check("3 200", "10813692");
	}

	@Test
	void case3() {
		check("100000 100000", "742202979");
	}
}
