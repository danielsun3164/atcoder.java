package other.joisc2007;

import java.io.File;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemK_LinesTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 4 6 4\n" + "0 0 6 6\n" + "1 0 1 6\n" + "0 6 6 0", "11");
	}

	@Test
	void case2() {
		check(new File("/daniel/tmp/Day4-data/Lines/04/lines.in"),
				new File("/daniel/tmp/Day4-data/Lines/04/lines.out"));
	}

	@Test
	void case3() {
		check(new File("/daniel/tmp/Day4-data/Lines/03/lines.in"),
				new File("/daniel/tmp/Day4-data/Lines/03/lines.out"));
	}
}
