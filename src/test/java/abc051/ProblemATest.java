package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("happy,newyear,enjoy");
		ProblemA.main(null);
		assertResultIs("happy newyear enjoy");
	}

	@Test
	void test_Case2() {
		in.input("haiku,atcoder,tasks");
		ProblemA.main(null);
		assertResultIs("haiku atcoder tasks");
	}

	@Test
	void test_Case3() {
		in.input("abcde,fghihgf,edcba");
		ProblemA.main(null);
		assertResultIs("abcde fghihgf edcba");
	}
}
