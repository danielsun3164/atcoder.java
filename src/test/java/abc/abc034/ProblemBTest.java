package abc.abc034;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("100", "99");
	}

	@Test
	void case2() {
		check("123456789", "123456790");
	}
}
