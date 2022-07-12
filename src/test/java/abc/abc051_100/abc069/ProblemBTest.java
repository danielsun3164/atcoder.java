package abc.abc051_100.abc069;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("internationalization", "i18n");
	}

	@Test
	void case2() {
		check("smiles", "s4s");
	}

	@Test
	void case3() {
		check("xyz", "x1z");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC080/B");
	}
}
