package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("6 2 1001", "1369");
	}

	@Test
	void case2() {
		check("1000 2 16", "6");
	}

	@Test
	void case3() {
		check("10000000000 10 99959", "492443256176507");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/E");
	}
}
