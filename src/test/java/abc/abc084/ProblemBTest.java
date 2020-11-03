package abc.abc084;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "269-6650", "Yes");
	}

	@Test
	void case2() {
		check("1 1\n" + "---", "No");
	}

	@Test
	void case3() {
		check("1 2\n" + "7444", "No");
	}
}
