package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3", "22");
	}

	@Test
	void case2() {
		check("11", "2022");
	}

	@Test
	void case3() {
		check("923423423420220108", "220022020000202020002022022000002020002222002200002022002200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/C");
	}
}
