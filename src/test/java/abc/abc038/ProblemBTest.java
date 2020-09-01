package abc.abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1080 1920\n" + "1080 1920", "YES");
	}

	@Test
	void case2() {
		check("1080 1920\n" + "1920 1080", "YES");
	}

	@Test
	void case3() {
		check("334 668\n" + "668 1002", "YES");
	}

	@Test
	void case4() {
		check("100 200\n" + "300 150", "NO");
	}

	@Test
	void case5() {
		check("120 120\n" + "240 240", "NO");
	}
}
