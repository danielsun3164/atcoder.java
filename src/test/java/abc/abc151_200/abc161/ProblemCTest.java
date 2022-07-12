package abc.abc151_200.abc161;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7 4", "1");
	}

	@Test
	void case2() {
		check("2 6", "2");
	}

	@Test
	void case3() {
		check("1000000000000000000 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC161/C");
	}
}
