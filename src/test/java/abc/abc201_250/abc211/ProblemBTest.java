package abc.abc201_250.abc211;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3B\n" + "HR\n" + "2B\n" + "H", "Yes");
	}

	@Test
	void case2() {
		check("2B\n" + "3B\n" + "HR\n" + "3B", "No");
	}
}
