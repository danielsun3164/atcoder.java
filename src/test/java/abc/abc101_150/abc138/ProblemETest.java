package abc.abc101_150.abc138;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("contest\n" + "son", "10");
	}

	@Test
	void case2() {
		check("contest\n" + "programming", "-1");
	}

	@Test
	void case3() {
		check("contest\n" + "sentence", "33");
	}
}
