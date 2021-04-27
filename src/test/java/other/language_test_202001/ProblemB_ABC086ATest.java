package other.language_test_202001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemB_ABC086ATest extends TestBase {

	@Test
	void case1() {
		check("3 4", "Even");
	}

	@Test
	void case2() {
		check("1 21", "Odd");
	}
}
