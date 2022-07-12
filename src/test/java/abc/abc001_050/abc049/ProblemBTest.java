package abc.abc001_050.abc049;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "*.\n" + ".*", "*." + LF + "*." + LF + ".*" + LF + ".*");
	}

	@Test
	void case2() {
		check("1 4\n" + "***.", "***." + LF + "***.");
	}

	@Test
	void case3() {
		check("9 20\n" + ".....***....***.....\n" + "....*...*..*...*....\n" + "...*.....**.....*...\n"
				+ "...*.....*......*...\n" + "....*.....*....*....\n" + ".....**..*...**.....\n"
				+ ".......*..*.*.......\n" + "........**.*........\n" + ".........**.........",
				".....***....***....." + LF + ".....***....***....." + LF + "....*...*..*...*...." + LF
						+ "....*...*..*...*...." + LF + "...*.....**.....*..." + LF + "...*.....**.....*..." + LF
						+ "...*.....*......*..." + LF + "...*.....*......*..." + LF + "....*.....*....*...." + LF
						+ "....*.....*....*...." + LF + ".....**..*...**....." + LF + ".....**..*...**....." + LF
						+ ".......*..*.*......." + LF + ".......*..*.*......." + LF + "........**.*........" + LF
						+ "........**.*........" + LF + ".........**........." + LF + ".........**.........");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC065/B");
	}
}
