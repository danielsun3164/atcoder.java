package abc177;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "11");
	}

	@Test
	void case2() {
		check("4\n" + "141421356 17320508 22360679 244949", "437235829");
	}
}
