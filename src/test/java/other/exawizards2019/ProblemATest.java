package other.exawizards2019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 2 2", "Yes");
	}

	@Test
	void case2() {
		check("3 4 5", "No");
	}
}
