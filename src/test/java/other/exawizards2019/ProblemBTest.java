package other.exawizards2019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "RRBR", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "BRBR", "No");
	}
}
