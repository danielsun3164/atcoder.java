package abc.abc151_200.abc187;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		checkResultIn("6\n" + "a\n" + "!a\n" + "b\n" + "!c\n" + "d\n" + "!d", "a", "d");
	}

	@Test
	void case2() {
		check("10\n" + "red\n" + "red\n" + "red\n" + "!orange\n" + "yellow\n" + "!blue\n" + "cyan\n" + "!green\n"
				+ "brown\n" + "!gray", "satisfiable");
	}
}
