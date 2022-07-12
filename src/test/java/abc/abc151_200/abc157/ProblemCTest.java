package abc.abc151_200.abc157;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 7\n" + "3 2\n" + "1 7", "702");
	}

	@Test
	void case2() {
		check("3 2\n" + "2 1\n" + "2 3", "-1");
	}

	@Test
	void case3() {
		check("3 1\n" + "1 0", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC157/C");
	}
}
