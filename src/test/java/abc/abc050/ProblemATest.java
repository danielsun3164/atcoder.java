package abc.abc050;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() throws ScriptException {
		check("1 + 2", "3");
	}

	@Test
	void case2() throws ScriptException {
		check("5 - 7", "-2");
	}
}
