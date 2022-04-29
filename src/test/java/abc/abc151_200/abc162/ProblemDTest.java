package abc.abc151_200.abc162;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "RRGB", "1");
	}

	@Test
	void case2() {
		check("39\n" + "RBRBGRBGGBBRRGBBRRRBGGBRBGBRBGBRBBBGBBB", "1800");
	}
}
