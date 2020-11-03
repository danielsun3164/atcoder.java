package abc.abc110;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("azzel\n" + "apple", "Yes");
	}

	@Test
	void case2() {
		check("chokudai\n" + "redcoder", "No");
	}

	@Test
	void case3() {
		check("abcdefghijklmnopqrstuvwxyz\n" + "ibyhqfrekavclxjstdwgpzmonu", "Yes");
	}
}
