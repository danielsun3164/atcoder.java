package abc.abc151_200.abc193;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 2 7 6\n" + "1 1 3 1\n" + "999999999 1 1000000000 1",
				"20" + LF + "infinity" + LF + "1000000000999999999");
	}
}
