package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 12\n" + "6 1 5", "3" + LF + "1" + LF + "7" + LF + "11");
	}
}
