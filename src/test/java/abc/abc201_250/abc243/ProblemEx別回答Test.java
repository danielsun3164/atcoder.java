package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemEx別回答Test extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "S..\n" + "O..\n" + "..O\n" + "..G", "Yes" + LF + "3 6");
	}

	@Test
	void case2() {
		check("3 2\n" + ".G\n" + ".O\n" + ".S", "No");
	}

	@Test
	void case3() {
		check("2 2\n" + "S.\n" + ".G", "Yes" + LF + "2 1");
	}

	@Test
	void case4() {
		check("10 10\n" + "OOO...OOO.\n" + ".....OOO.O\n" + "OOO.OO.OOO\n" + "OOO..O..S.\n" + "....O.O.O.\n"
				+ ".OO.O.OOOO\n" + "..OOOG.O.O\n" + ".O.O..OOOO\n" + ".O.O.OO...\n" + "...O..O..O",
				"Yes" + LF + "10 12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/Ex");
	}
}
