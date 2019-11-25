package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input(". . . .\n" + ". o o .\n" + ". x x .\n" + ". . . .");
		ProblemB.main(null);
		assertResultIs(". . . .\n" + ". x x .\n" + ". o o .\n" + ". . . .");
	}

	@Test
	void case2() {
		in.input("o o x x\n" + "o o x x\n" + "x x o o\n" + "x x o o");
		ProblemB.main(null);
		assertResultIs("o o x x\n" + "o o x x\n" + "x x o o\n" + "x x o o");
	}
}
