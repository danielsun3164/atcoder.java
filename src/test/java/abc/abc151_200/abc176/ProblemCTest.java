package abc.abc151_200.abc176;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 1 5 4 3", "4");
	}

	@Test
	void case2() {
		check("5\n" + "3 3 3 3 3", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC176/C");
	}
}
