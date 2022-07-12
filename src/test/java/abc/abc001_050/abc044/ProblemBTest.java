package abc.abc001_050.abc044;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abaccaba", "Yes");
	}

	@Test
	void case2() {
		check("hthth", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC060/B");
	}
}
