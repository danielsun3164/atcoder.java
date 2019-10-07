package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX4Test extends TestBase {

	@Test
	void test_Case1() {
		ProblemEX4.main(null);
		assertResultIs("31536000" + LF + "63072000" + LF + "157680000" + LF + "315360000");
	}
}
