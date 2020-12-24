package abc.abc132;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3", "3" + LF + "6" + LF + "1");
	}

	@Test
	void case2() {
		check("2000 3", "1998" + LF + "3990006" + LF + "327341989");
	}
}
