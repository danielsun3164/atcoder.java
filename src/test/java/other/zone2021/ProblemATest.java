package other.zone2021;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("abcdZONefghi", "1");
	}

	@Test
	void case2() {
		check("ZONeZONeZONe", "3");
	}

	@Test
	void case3() {
		check("helloAtZoner", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ZONe2021/A");
	}
}
