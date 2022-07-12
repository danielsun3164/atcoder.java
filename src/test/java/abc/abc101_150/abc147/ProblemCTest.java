package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1\n" + "2 1\n" + "1\n" + "1 1\n" + "1\n" + "2 0", "2");
	}

	@Test
	void case2() {
		check("3\n" + "2\n" + "2 1\n" + "3 0\n" + "2\n" + "3 1\n" + "1 0\n" + "2\n" + "1 1\n" + "2 0", "0");
	}

	@Test
	void case3() {
		check("2\n" + "1\n" + "2 0\n" + "1\n" + "1 0", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/C");
	}
}
