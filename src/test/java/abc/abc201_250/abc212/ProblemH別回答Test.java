package abc.abc201_250.abc212;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemH別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1 2", "4");
	}

	@Test
	void case2() {
		check("100 3\n" + "3 5 7", "112184936");
	}
}
