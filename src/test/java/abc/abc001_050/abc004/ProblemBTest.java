package abc.abc001_050.abc004;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check(". . . .\n" + ". o o .\n" + ". x x .\n" + ". . . .",
				". . . ." + LF + ". x x ." + LF + ". o o ." + LF + ". . . .");
	}

	@Test
	void case2() {
		check("o o x x\n" + "o o x x\n" + "x x o o\n" + "x x o o",
				"o o x x" + LF + "o o x x" + LF + "x x o o" + LF + "x x o o");
	}
}
