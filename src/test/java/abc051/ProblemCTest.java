package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("0 0 1 2");
		ProblemC.main(null);
		assertResultIs("UURDDLLUUURRDRDDDLLU");
	}

	@Test
	void case2() {
		in.input("-2 -2 1 1");
		ProblemC.main(null);
		assertResultIn("UUURRRDDDLLLLUUUURRRRDRDDDDLLLLU", "UURRURRDDDLLDLLULUUURRURRDDDLLDL");
	}
}
