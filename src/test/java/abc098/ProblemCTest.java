package abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "WEEWW");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("12\n" + "WEWEWEEEWWWE");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("8\n" + "WWWWWEEE");
		ProblemC.main(null);
		assertResultIs("3");
	}
}
