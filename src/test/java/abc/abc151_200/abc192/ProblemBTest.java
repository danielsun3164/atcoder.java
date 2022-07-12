package abc.abc151_200.abc192;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("dIfFiCuLt", "Yes");
	}

	@Test
	void case2() {
		check("eASY", "No");
	}

	@Test
	void case3() {
		check("a", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC192/B");
	}
}
