package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check(". . . .\n" + ". o o .\n" + ". x x .\n" + ". . . .", ". . . .\n" + ". x x .\n" + ". o o .\n" + ". . . .");
	}

	@Test
	void case2() {
		check("o o x x\n" + "o o x x\n" + "x x o o\n" + "x x o o", "o o x x\n" + "o o x x\n" + "x x o o\n" + "x x o o");
	}
}
