package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "2");
	}

	@Test
	void case2() {
		check("39 14", "74764168");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/F");
	}
}
