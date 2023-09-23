package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 5 2\n" + "26", "8");
	}

	@Test
	void case2() {
		check("4\n" + "12 34 56 78\n" + "1000", "23");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/C");
	}
}
