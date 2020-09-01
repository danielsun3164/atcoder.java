package abc.abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("0 0 1 2", "UURDDLLUUURRDRDDDLLU");
	}

	@Test
	void case2() {
		checkResultIn("-2 -2 1 1", "UUURRRDDDLLLLUUUURRRRDRDDDDLLLLU", "UURRURRDDDLLDLLULUUURRURRDDDLLDL");
	}
}
