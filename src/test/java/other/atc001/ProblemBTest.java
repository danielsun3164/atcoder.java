package other.atc001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8 9\n" + "0 1 2\n" + "0 3 2\n" + "1 1 3\n" + "1 1 4\n" + "0 2 4\n" + "1 4 1\n" + "0 4 2\n" + "0 0 0\n"
				+ "1 0 0", "Yes" + LF + "No" + LF + "Yes" + LF + "Yes");
	}
}
