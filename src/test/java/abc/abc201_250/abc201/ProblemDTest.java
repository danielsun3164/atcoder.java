package abc.abc201_250.abc201;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "---\n" + "+-+\n" + "+--", "Takahashi");
	}

	@Test
	void case2() {
		check("2 4\n" + "+++-\n" + "-+-+", "Aoki");
	}

	@Test
	void case3() {
		check("1 1\n" + "-", "Draw");
	}
}
