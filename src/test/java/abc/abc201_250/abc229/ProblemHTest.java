package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "BB.\n" + ".B.\n" + "...", "Takahashi");
	}

	@Test
	void case2() {
		check("2\n" + "..\n" + "WW", "Snuke");
	}

	@Test
	void case3() {
		check("4\n" + "WWBW\n" + "WWWW\n" + "BWB.\n" + "BBBB", "Snuke");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/H");
	}
}
