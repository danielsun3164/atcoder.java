package abc.abc151_200.abc160;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1024", "2020");
	}

	@Test
	void case2() {
		check("0", "0");
	}

	@Test
	void case3() {
		check("1000000000", "2000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC160/B");
	}
}
