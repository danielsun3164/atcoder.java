package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem043Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 1\n" + "3 3\n" + "..#\n" + "#.#\n" + "#..", "2");
	}

	@Test
	void case2() {
		check("3 3\n" + "2 1\n" + "2 3\n" + "#.#\n" + "...\n" + "#.#", "0");
	}

	@Test
	void case3() {
		check("4 6\n" + "2 1\n" + "1 5\n" + "...#..\n" + ".#.##.\n" + ".#....\n" + "...##.", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/043");
	}
}
