package abc.abc151_200.abc173;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3 2\n" + "..#\n" + "###", "5");
	}

	@Test
	void case2() {
		check("2 3 4\n" + "..#\n" + "###", "1");
	}

	@Test
	void case3() {
		check("2 2 3\n" + "##\n" + "##", "0");
	}

	@Test
	void case4() {
		check("6 6 8\n" + "..##..\n" + ".#..#.\n" + "#....#\n" + "######\n" + "#....#\n" + "#....#", "208");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC173/C");
	}
}
