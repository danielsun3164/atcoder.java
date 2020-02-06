package abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("?tc????\n" + "coder");
		ProblemC.main(null);
		assertResultIs("atcoder");
	}

	@Test
	void case2() {
		in.input("??p??d??\n" + "abc");
		ProblemC.main(null);
		assertResultIs("UNRESTORABLE");
	}
}
