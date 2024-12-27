package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "90 180 45 195", "120");
	}

	@Test
	void case2() {
		check("1\n" + "1", "359");
	}

	@Test
	void case3() {
		check("10\n" + "215 137 320 339 341 41 44 18 241 149", "170");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/B");
	}
}
