package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD_BuildingTest extends TestBase {

	@Test
	void case1() {
		check("9\n" + "3\n" + "7\n" + "5\n" + "9\n" + "8\n" + "10\n" + "10\n" + "11\n" + "9", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Building");
	}
}
