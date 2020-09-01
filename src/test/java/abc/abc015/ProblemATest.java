package abc.abc015;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("isuruu\n" + "isleapyear", "isleapyear");
	}

	@Test
	void case2() {
		check("ttttiiiimmmmeeee\n" + "time", "ttttiiiimmmmeeee");
	}
}
