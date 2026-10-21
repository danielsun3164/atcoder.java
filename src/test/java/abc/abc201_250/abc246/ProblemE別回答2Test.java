package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答2Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 3\n" + "3 5\n" + "....#\n" + "...#.\n" + ".....\n" + ".#...\n" + "#....", "3");
	}

	@Test
	void case2() {
		check("4\n" + "3 2\n" + "4 2\n" + "....\n" + "....\n" + "....\n" + "....", "-1");
	}

	@Test
	void case3() {
		check("18\n" + "18 1\n" + "1 18\n" + "..................\n" + ".####.............\n" + ".#..#..####.......\n"
				+ ".####..#..#..####.\n" + ".#..#..###...#....\n" + ".#..#..#..#..#....\n" + ".......####..#....\n"
				+ ".............####.\n" + "..................\n" + "..................\n" + ".####.............\n"
				+ "....#..#..#.......\n" + ".####..#..#..####.\n" + ".#.....####..#....\n" + ".####.....#..####.\n"
				+ "..........#..#..#.\n" + ".............####.\n" + "..................", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/E");
	}
}
