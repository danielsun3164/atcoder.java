package other.apg4b;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemEX4Test extends TestBase {

	@Test
	void case1() {
		execute();
		assertResultIs("31536000" + LF + "63072000" + LF + "157680000" + LF + "315360000");
	}
}
