package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX16Test extends TestBase {

	@Test
	void case1() {
		check("5 3 3 1 4", "YES");
	}

	@Test
	void case2() {
		check("1 1 2 3 4", "YES");
	}

	@Test
	void case3() {
		check("1 2 1 2 1", "NO");
	}

	@Test
	void case4() {
		check("100 100 100 100 100", "YES");
	}
}
