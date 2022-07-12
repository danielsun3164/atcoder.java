package abc.abc151_200.abc183;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC183/E");
	}
}
