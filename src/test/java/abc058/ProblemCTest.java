package abc058;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "cbaa\n" + "daacc\n" + "acacac");
		ProblemC.main(null);
		assertResultIs("aac");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "a\n" + "aa\n" + "b");
		ProblemC.main(null);
		assertResultIs("");
	}
}
