package abc.abc151_200.abc192;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("140", "60");
	}

	@Test
	void case2() {
		check("1000", "100");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC192/A");
	}
}
