package abc.abc003;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("ch@ku@ai\n" + "choku@@i", "You can win");
	}

	@Test
	void case2() {
		check("aoki\n" + "@ok@", "You will lose");
	}

	@Test
	void case3() {
		check("arc\n" + "abc", "You will lose");
	}
}
