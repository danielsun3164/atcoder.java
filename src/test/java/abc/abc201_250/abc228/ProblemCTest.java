package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "178 205 132\n" + "112 220 96\n" + "36 64 20", "Yes" + LF + "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("2 1\n" + "300 300 300\n" + "200 200 200", "Yes" + LF + "Yes");
	}

	@Test
	void case3() {
		check("4 2\n" + "127 235 78\n" + "192 134 298\n" + "28 56 42\n" + "96 120 250",
				"Yes" + LF + "Yes" + LF + "No" + LF + "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/C");
	}
}
