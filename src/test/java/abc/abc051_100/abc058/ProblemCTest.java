package abc.abc051_100.abc058;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "cbaa\n" + "daacc\n" + "acacac", "aac");
	}

	@Test
	void case2() {
		check("3\n" + "a\n" + "aa\n" + "b", "");
	}
}
