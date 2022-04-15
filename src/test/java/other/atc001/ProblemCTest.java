package other.atc001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 1\n" + "2 2\n" + "3 4\n" + "4 8",
				"0" + LF + "1" + LF + "4" + LF + "11" + LF + "26" + LF + "36" + LF + "40" + LF + "32");
	}
}
