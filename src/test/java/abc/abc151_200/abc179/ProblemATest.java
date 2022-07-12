package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("apple", "apples");
	}

	@Test
	void case2() {
		check("bus", "buses");
	}

	@Test
	void case3() {
		check("box", "boxs");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/A");
	}
}
