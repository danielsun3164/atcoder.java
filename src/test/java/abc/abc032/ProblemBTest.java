package abc.abc032;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abcabc\n" + "2", "3");
	}

	@Test
	void case2() {
		check("aaaaa\n" + "1", "1");
	}

	@Test
	void case3() {
		check("hello\n" + "10", "0");
	}
}
