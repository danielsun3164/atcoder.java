package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX1Test extends TestBase {

	@Test
	void test_Case1() {
		ProblemEX1.main(null);
		assertResultIs("こんにちは" + LF + "AtCoder");
	}
}