package abc.abc177;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "2 4\n" + "1 1\n" + "2 3\n" + "2 4", "1" + LF + "3" + LF + "6" + LF + "-1");
	}
}
