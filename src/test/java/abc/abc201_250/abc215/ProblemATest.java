package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("Hello,World!", "AC");
	}

	@Test
	void case2() {
		check("Hello,world!", "WA");
	}

	@Test
	void case3() {
		check("Hello!World!", "WA");
	}
}
