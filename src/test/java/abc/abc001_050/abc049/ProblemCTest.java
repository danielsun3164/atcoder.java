package abc.abc001_050.abc049;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("erasedream", "YES");
	}

	@Test
	void case2() {
		check("dreameraser", "YES");
	}

	@Test
	void case3() {
		check("dreamerer", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC065/C");
	}
}
