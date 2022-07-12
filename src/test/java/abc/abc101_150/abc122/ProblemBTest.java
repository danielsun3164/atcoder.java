package abc.abc101_150.abc122;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("ATCODER", "3");
	}

	@Test
	void case2() {
		check("HATAGAYA", "5");
	}

	@Test
	void case3() {
		check("SHINJUKU", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC122/B");
	}
}
