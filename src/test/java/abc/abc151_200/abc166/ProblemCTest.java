package abc.abc151_200.abc166;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2 3 4\n" + "1 3\n" + "2 3\n" + "2 4", "2");
	}

	@Test
	void case2() {
		check("6 5\n" + "8 6 9 1 2 1\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 6\n" + "4 6", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC166/C");
	}
}
