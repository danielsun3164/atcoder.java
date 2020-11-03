package other.hhkb2020;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 1 2\n" + "4 2 2\n" + "331895368 154715807 13941326", "20\n" + "32\n" + "409369707");
	}
}
