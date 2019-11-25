package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("happy,newyear,enjoy");
		ProblemA.main(null);
		assertResultIs("happy newyear enjoy");
	}

	@Test
	void case2() {
		in.input("haiku,atcoder,tasks");
		ProblemA.main(null);
		assertResultIs("haiku atcoder tasks");
	}

	@Test
	void case3() {
		in.input("abcde,fghihgf,edcba");
		ProblemA.main(null);
		assertResultIs("abcde fghihgf edcba");
	}
}
