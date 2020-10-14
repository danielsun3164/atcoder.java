package abc.abc017;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("chokuou", "YES");
	}

	@Test
	void case2() {
		check("kuccho", "NO");
	}

	@Test
	void case3() {
		check("atcoder", "NO");
	}
}
