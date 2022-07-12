package abc.abc101_150.abc135;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 5 2\n" + "4 5", "9");
	}

	@Test
	void case2() {
		check("3\n" + "5 6 3 8\n" + "5 100 8", "22");
	}

	@Test
	void case3() {
		check("2\n" + "100 1 1\n" + "1 100", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/C");
	}
}
