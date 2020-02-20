package abc079;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws ScriptException {
		in.input("1222");
		ProblemC.main(null);
		assertResultIs("1+2+2+2=7");
	}

	@Test
	void case2() throws ScriptException {
		in.input("0290");
		ProblemC.main(null);
		assertResultIn("0-2+9+0=7", "0-2+9-0=7");
	}

	@Test
	void case3() throws ScriptException {
		in.input("3242");
		ProblemC.main(null);
		assertResultIn("3+2+4-2=7", "3-2+4+2=7");
	}
}
