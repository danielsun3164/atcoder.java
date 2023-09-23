package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + ".....\n" + "..#..\n" + ".###.\n" + ".....\n" + ".....\n" + ".....\n" + ".....\n" + "....#\n"
				+ "...##\n" + "....#", "Yes");
	}

	@Test
	void case2() {
		check("5\n" + "#####\n" + "##..#\n" + "#..##\n" + "#####\n" + ".....\n" + "#####\n" + "#..##\n" + "##..#\n"
				+ "#####\n" + ".....", "No");
	}

	@Test
	void case3() {
		check("4\n" + "#...\n" + "..#.\n" + "..#.\n" + "....\n" + "#...\n" + "#...\n" + "..#.\n" + "....", "Yes");
	}

	@Test
	void case4() {
		check("4\n" + "#...\n" + ".##.\n" + "..#.\n" + "....\n" + "##..\n" + "#...\n" + "..#.\n" + "....", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/C");
	}
}
