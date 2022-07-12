package abc.abc051_100.abc098;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "WEEWW", "1");
	}

	@Test
	void case2() {
		check("12\n" + "WEWEWEEEWWWE", "4");
	}

	@Test
	void case3() {
		check("8\n" + "WWWWWEEE", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC098/C");
	}
}
