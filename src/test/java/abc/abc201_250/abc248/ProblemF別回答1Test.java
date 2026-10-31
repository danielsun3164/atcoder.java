package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答1Test extends TestBase {

	@Test
	void case1() {
		check("3 998244353", "7 15");
	}

	@Test
	void case2() {
		check("16 999999937",
				"46 1016 14288 143044 1079816 6349672 29622112 110569766 330377828 784245480 453609503 38603306 44981526 314279703 408855776");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/F");
	}
}
