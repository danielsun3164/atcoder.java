package abc.abc060;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("rng gorilla apple", "YES");
	}

	@Test
	void case2() {
		check("yakiniku unagi sushi", "NO");
	}

	@Test
	void case3() {
		check("a a a", "YES");
	}

	@Test
	void case4() {
		check("aaaaaaaaab aaaaaaaaaa aaaaaaaaab", "NO");
	}
}
