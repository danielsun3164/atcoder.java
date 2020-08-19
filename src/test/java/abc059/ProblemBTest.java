package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("36\n" + "24", "GREATER");
	}

	@Test
	void case2() {
		check("850\n" + "3777", "LESS");
	}

	@Test
	void case3() {
		check("9720246\n" + "22516266", "LESS");
	}

	@Test
	void case4() {
		check("123456789012345678901234567890\n" + "234567890123456789012345678901", "LESS");
	}
}
