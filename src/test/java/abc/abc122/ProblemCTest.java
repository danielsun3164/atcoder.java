package abc.abc122;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("8 3\n" + "ACACTACG\n" + "3 7\n" + "2 3\n" + "1 8", "2" + LF + "0" + LF + "3");
	}
}
