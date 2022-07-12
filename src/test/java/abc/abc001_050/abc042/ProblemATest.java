package abc.abc001_050.abc042;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 5 7", "YES");
	}

	@Test
	void case2() {
		check("7 7 5", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC058_ABC042/A");
	}
}
