package abc.abc079;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws ScriptException {
		check("1222", "1+2+2+2=7");
	}

	@Test
	void case2() throws ScriptException {
		checkResultIn("0290", "0-2+9+0=7", "0-2+9-0=7");
	}

	@Test
	void case3() throws ScriptException {
		checkResultIn("3242", "3+2+4-2=7", "3-2+4+2=7");
	}
}
