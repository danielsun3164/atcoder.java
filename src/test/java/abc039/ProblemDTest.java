package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 4\n" + "##..\n" + "##..\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("possible" + LF + "#..." + LF + "...." + LF + "...." + LF + "...#");
	}

	@Test
	void case2() {
		in.input("4 4\n" + "###.\n" + "####\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("possible" + LF + "##.." + LF + "...." + LF + "...#" + LF + "...#");
	}

	@Test
	void case3() {
		in.input("4 4\n" + "###.\n" + "##.#\n" + "..##\n" + "..##");
		ProblemD.main(null);
		assertResultIs("impossible");
	}
}
