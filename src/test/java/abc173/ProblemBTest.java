package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "AC\n" + "TLE\n" + "AC\n" + "AC\n" + "WA\n" + "TLE");
		ProblemB.main(null);
		assertResultIs("AC x 3\n" + "WA x 1\n" + "TLE x 2\n" + "RE x 0");
	}

	@Test
	void case2() {
		in.input("10\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC");
		ProblemB.main(null);
		assertResultIs("AC x 10\n" + "WA x 0\n" + "TLE x 0\n" + "RE x 0");
	}
}
