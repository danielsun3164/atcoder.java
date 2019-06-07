package abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("12\n" + "18\n" + "11");
		ProblemA.main(null);
		assertResultIs("2" + LF + "1" + LF + "3");
	}

	@Test
	void test_Case2() {
		in.input("10\n" + "20\n" + "30");
		ProblemA.main(null);
		assertResultIs("3" + LF + "2" + LF + "1");
	}
}
