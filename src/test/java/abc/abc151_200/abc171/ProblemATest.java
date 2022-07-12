package abc.abc151_200.abc171;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("B", "A");
	}

	@Test
	void case2() {
		check("a", "a");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC171/A");
	}
}
