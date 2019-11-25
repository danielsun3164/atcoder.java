package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX16Test extends TestBase {

	@Test
	void case1() {
		in.input("5 3 3 1 4");
		ProblemEX16.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("1 1 2 3 4");
		ProblemEX16.main(null);
		assertResultIs("YES");
	}

	@Test
	void case3() {
		in.input("1 2 1 2 1");
		ProblemEX16.main(null);
		assertResultIs("NO");
	}

	@Test
	void case4() {
		in.input("100 100 100 100 100");
		ProblemEX16.main(null);
		assertResultIs("YES");
	}
}
