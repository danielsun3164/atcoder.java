package abc.abc001_050.abc045;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("aca\n" + "accc\n" + "ca", "A");
	}

	@Test
	void case2() {
		check("abcb\n" + "aacb\n" + "bccc", "C");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC061/B");
	}
}
