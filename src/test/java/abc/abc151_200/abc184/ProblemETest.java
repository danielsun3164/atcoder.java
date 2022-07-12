package abc.abc151_200.abc184;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "S.b.b\n" + "a.a.G", "4");
	}

	@Test
	void case2() {
		check("11 11\n" + "S##...#c...\n" + "...#d.#.#..\n" + "..........#\n" + ".#....#...#\n" + "#.....bc...\n"
				+ "#.##......#\n" + ".......c..#\n" + "..#........\n" + "a..........\n" + "d..#...a...\n"
				+ ".#........G", "14");
	}

	@Test
	void case3() {
		check("11 11\n" + ".#.#.e#a...\n" + ".b..##..#..\n" + "#....#.#..#\n" + ".#dd..#..#.\n" + "....#...#e.\n"
				+ "c#.#a....#.\n" + ".....#..#.e\n" + ".#....#b.#.\n" + ".#...#..#..\n" + "......#c#G.\n"
				+ "#..S...#...", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC184/E");
	}
}
