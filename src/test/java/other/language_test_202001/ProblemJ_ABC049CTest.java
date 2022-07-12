package other.language_test_202001;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemJ_ABC049CTest extends TestBase {

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
