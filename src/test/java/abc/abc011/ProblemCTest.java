package abc.abc011;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1\n" + "7\n" + "15", "YES");
	}

	@Test
	void case2() {
		check("5\n" + "1\n" + "4\n" + "2", "YES");
	}

	@Test
	void case3() {
		check("300\n" + "57\n" + "121\n" + "244", "NO");
	}
}
