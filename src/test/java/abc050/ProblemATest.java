package abc050;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() throws ScriptException {
		in.input("1 + 2");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() throws ScriptException {
		in.input("5 - 7");
		ProblemA.main(null);
		assertResultIs("-2");
	}
}
