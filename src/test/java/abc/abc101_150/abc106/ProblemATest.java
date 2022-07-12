package abc.abc101_150.abc106;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 2", "1");
	}

	@Test
	void case2() {
		check("5 7", "24");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC106/A");
	}
}
