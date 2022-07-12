package abc.abc051_100.abc054;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "1 3\n" + "2 3", "2");
	}

	@Test
	void case2() {
		check("7 7\n" + "1 3\n" + "2 7\n" + "3 4\n" + "4 5\n" + "4 6\n" + "5 6\n" + "6 7", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC054/C");
	}
}
