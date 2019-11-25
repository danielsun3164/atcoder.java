package abc015;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("isuruu\n" + "isleapyear");
		ProblemA.main(null);
		assertResultIs("isleapyear");
	}

	@Test
	void case2() {
		in.input("ttttiiiimmmmeeee\n" + "time");
		ProblemA.main(null);
		assertResultIs("ttttiiiimmmmeeee");
	}
}
