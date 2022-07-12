package abc.abc001_050.abc042;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "dxx\n" + "axx\n" + "cxx", "axxcxxdxx");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC058_ABC042/B");
	}
}
