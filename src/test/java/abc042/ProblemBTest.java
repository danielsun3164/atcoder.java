package abc042;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3\n" + "dxx\n" + "axx\n" + "cxx");
		ProblemB.main(null);
		assertResultIs("axxcxxdxx");
	}
}
