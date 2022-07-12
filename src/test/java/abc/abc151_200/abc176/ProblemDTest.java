package abc.abc151_200.abc176;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 1\n" + "4 4\n" + "..#.\n" + "..#.\n" + ".#..\n" + ".#..", "1");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 4\n" + "4 1\n" + ".##.\n" + "####\n" + "####\n" + ".##.", "-1");
	}

	@Test
	void case3() {
		check("4 4\n" + "2 2\n" + "3 3\n" + "....\n" + "....\n" + "....\n" + "....", "0");
	}

	@Test
	void case4() {
		check("4 5\n" + "1 2\n" + "2 5\n" + "#.###\n" + "####.\n" + "#..##\n" + "#..##", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC176/D");
	}
}
