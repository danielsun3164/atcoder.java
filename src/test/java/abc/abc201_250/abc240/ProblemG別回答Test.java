package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 2 0 -1", "3");
	}

	@Test
	void case2() {
		check("1 0 0 0", "0");
	}

	@Test
	void case3() {
		check("314 15 92 65", "106580952");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/G");
	}
}
