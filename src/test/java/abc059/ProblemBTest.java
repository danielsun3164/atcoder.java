package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("36\n" + "24");
		ProblemB.main(null);
		assertResultIs("GREATER");
	}

	@Test
	void case2() {
		in.input("850\n" + "3777");
		ProblemB.main(null);
		assertResultIs("LESS");
	}

	@Test
	void case3() {
		in.input("9720246\n" + "22516266");
		ProblemB.main(null);
		assertResultIs("LESS");
	}

	@Test
	void case4() {
		in.input("123456789012345678901234567890\n" + "234567890123456789012345678901");
		ProblemB.main(null);
		assertResultIs("LESS");
	}
}
