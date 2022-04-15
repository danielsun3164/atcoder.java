package other.atc002;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2 3 4 9 3", "53");
	}
}
