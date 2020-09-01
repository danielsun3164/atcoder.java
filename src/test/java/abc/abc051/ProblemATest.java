package abc.abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("happy,newyear,enjoy", "happy newyear enjoy");
	}

	@Test
	void case2() {
		check("haiku,atcoder,tasks", "haiku atcoder tasks");
	}

	@Test
	void case3() {
		check("abcde,fghihgf,edcba", "abcde fghihgf edcba");
	}
}
