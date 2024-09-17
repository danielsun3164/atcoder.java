package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH_RouteTest extends TestBase {

	@Test
	void case1() {
		check("5 6\n" + "0 0\n" + "10 10\n" + "0 10\n" + "10 0\n" + "2 -6\n" + "1 2 30\n" + "1 3 4\n" + "1 4 5\n"
				+ "1 5 1\n" + "2 4 3\n" + "2 5 1", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Route");
	}
}
