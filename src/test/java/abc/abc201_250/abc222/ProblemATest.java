package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("321", "0321");
	}

	@Test
	void case2() {
		check("7777", "7777");
	}

	@Test
	void case3() {
		check("1", "0001");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/A");
	}
}
