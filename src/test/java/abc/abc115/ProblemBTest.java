package abc.abc115;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4980\n" + "7980\n" + "6980", "15950");
	}

	@Test
	void case2() {
		check("4\n" + "4320\n" + "4320\n" + "4320\n" + "4320", "15120");
	}
}
