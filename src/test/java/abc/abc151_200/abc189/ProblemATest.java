package abc.abc151_200.abc189;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("SSS", "Won");
	}

	@Test
	void case2() {
		check("WVW", "Lost");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC189/A");
	}
}
