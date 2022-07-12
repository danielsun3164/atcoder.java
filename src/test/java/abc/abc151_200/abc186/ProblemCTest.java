package abc.abc151_200.abc186;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("20", "17");
	}

	@Test
	void case2() {
		check("100000", "30555");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC186/C");
	}
}
