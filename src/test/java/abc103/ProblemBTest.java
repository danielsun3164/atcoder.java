package abc103;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("kyoto\n" + "tokyo", "Yes");
	}

	@Test
	void case2() {
		check("abc\n" + "arc", "No");
	}

	@Test
	void case3() {
		check("aaaaaaaaaaaaaaab\n" + "aaaaaaaaaaaaaaab", "Yes");
	}
}
