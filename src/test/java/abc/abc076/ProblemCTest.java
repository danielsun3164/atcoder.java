package abc.abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("?tc????\n" + "coder", "atcoder");
	}

	@Test
	void case2() {
		check("??p??d??\n" + "abc", "UNRESTORABLE");
	}
}