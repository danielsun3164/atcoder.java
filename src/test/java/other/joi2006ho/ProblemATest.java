package other.joi2006ho;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "1 0 1 0 1 1\n" + "1 1 0 1 0 0\n" + "1 1 1 0 0 0\n" + "1 0 1 0 1 0", "1 3 2 5 4 6");
	}
}
