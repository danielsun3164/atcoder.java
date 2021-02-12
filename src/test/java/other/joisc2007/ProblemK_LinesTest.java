package other.joisc2007;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemK_LinesTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 4 6 4\n" + "0 0 6 6\n" + "1 0 1 6\n" + "0 6 6 0", "11");
	}
}
