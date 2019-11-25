package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1080 1920\n" + "1080 1920");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("1080 1920\n" + "1920 1080");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case3() {
		in.input("334 668\n" + "668 1002");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case4() {
		in.input("100 200\n" + "300 150");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case5() {
		in.input("120 120\n" + "240 240");
		ProblemB.main(null);
		assertResultIs("NO");
	}
}
