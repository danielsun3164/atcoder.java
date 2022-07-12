package abc.abc051_100.abc089;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "G W Y P Y W", "Four");
	}

	@Test
	void case2() {
		check("9\n" + "G W W G P W P G G", "Three");
	}

	@Test
	void case3() {
		check("8\n" + "P Y W G Y W Y Y", "Four");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC089/B");
	}
}
