package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "abcde", "e");
	}

	@Test
	void case2() {
		check("1\n" + "a", "a");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/A");
	}
}
