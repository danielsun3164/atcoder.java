package other.joi2006ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5", "5" + LF + "4 1" + LF + "3 2" + LF + "3 1 1" + LF + "2 2 1" + LF + "2 1 1 1" + LF + "1 1 1 1 1");
	}
}
