package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "##...\n" + ".##..\n" + "#.#..\n" + ".....\n" + "....#", "4");
	}

	@Test
	void case2() {
		check("3\n" + "...\n" + "...\n" + "...", "0");
	}

	@Test
	void case3() {
		check("21\n" + ".....................\n" + ".....................\n" + "...#.#...............\n"
				+ "....#.............#..\n" + "...#.#...........#.#.\n" + "..................#..\n"
				+ ".....................\n" + ".....................\n" + ".....................\n"
				+ "..........#.....#....\n" + "......#..###.........\n" + "........#####..#.....\n"
				+ ".......#######.......\n" + ".....#..#####........\n" + ".......#######.......\n"
				+ "......#########......\n" + ".......#######..#....\n" + "......#########......\n"
				+ "..#..###########.....\n" + ".........###.........\n" + ".........###.........", "19");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/G");
	}
}
