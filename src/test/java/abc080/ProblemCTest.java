package abc080;

import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws ScriptException {
		in.input("1\n" + "1 1 0 1 0 0 0 1 0 1\n" + "3 4 5 6 7 8 9 -2 -3 4 -2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() throws ScriptException {
		in.input("2\n" + "1 1 1 1 1 0 0 0 0 0\n" + "0 0 0 0 0 1 1 1 1 1\n" + "0 -2 -2 -2 -2 -2 -1 -1 -1 -1 -1\n"
				+ "0 -2 -2 -2 -2 -2 -1 -1 -1 -1 -1");
		ProblemC.main(null);
		assertResultIn("-2");
	}

	@Test
	void case3() throws ScriptException {
		in.input("3\n" + "1 1 1 1 1 1 0 0 1 1\n" + "0 1 0 1 1 1 1 0 1 0\n" + "1 0 1 1 0 1 0 1 0 1\n"
				+ "-8 6 -2 -8 -8 4 8 7 -6 2 2\n" + "-9 2 0 1 7 -5 0 -2 -6 5 5\n" + "6 -6 7 -9 6 -5 8 0 -9 -7 -7");
		ProblemC.main(null);
		assertResultIn("23");
	}
}
