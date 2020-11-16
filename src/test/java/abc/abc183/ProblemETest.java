package abc.abc183;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "...\n" + ".#.\n" + "...", "10");
	}

	@Test
	void case2() {
		check("4 4\n" + "...#\n" + "....\n" + "..#.\n" + "....", "84");
	}

	@Test
	void case3() {
		check("8 10\n" + "..........\n" + "..........\n" + "..........\n" + "..........\n" + "..........\n"
				+ "..........\n" + "..........\n" + "..........", "13701937");
	}
}
