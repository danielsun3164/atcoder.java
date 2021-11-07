package abc.abc201_250.abc210;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "00101", "Takahashi");
	}

	@Test
	void case2() {
		check("3\n" + "010", "Aoki");
	}
}
