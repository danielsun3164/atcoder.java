package abc.abc151_200.abc166;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ABC", "ARC");
	}

	@Test
	void case2() {
		check("ARC", "ABC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC166/A");
	}
}
