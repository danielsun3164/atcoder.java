package abc.abc101_150.abc138;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3200\n" + "pink", "pink");
	}

	@Test
	void case2() {
		check("3199\n" + "pink", "red");
	}

	@Test
	void case3() {
		check("4049\n" + "red", "red");
	}
}
