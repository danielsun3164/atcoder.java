package abc.abc151_200.abc168;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("16", "pon");
	}

	@Test
	void case2() {
		check("2", "hon");
	}

	@Test
	void case3() {
		check("183", "bon");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/A");
	}
}
