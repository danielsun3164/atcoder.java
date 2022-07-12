package abc.abc051_100.abc058;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "cbaa\n" + "daacc\n" + "acacac", "aac");
	}

	@Test
	void case2() {
		check("3\n" + "a\n" + "aa\n" + "b", "");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC071/C");
	}
}
