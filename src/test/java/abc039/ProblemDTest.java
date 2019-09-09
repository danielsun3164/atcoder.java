package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 4\n" + "##..\n" + "##..\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("possible" + LF + "#..." + LF + "...." + LF + "...." + LF + "...#");
	}

	@Test
	void test_Case2() {
		in.input("4 4\n" + "###.\n" + "####\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("possible" + LF + "##.." + LF + "...." + LF + "...#" + LF + "...#");
	}

	@Test
	void test_Case3() {
		in.input("4 4\n" + "###.\n" + "##.#\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("impossible");
	}
}
