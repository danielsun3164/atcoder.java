package abc.abc001_050.abc009;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "abc", "abc");
	}

	@Test
	void case2() {
		check("7 2\n" + "atcoder", "actoder");
	}

	@Test
	void case3() {
		check("7 7\n" + "atcoder", "acdeort");
	}

	@Test
	void case4() {
		check("10 3\n" + "helloworld", "dehloworll");
	}
}
