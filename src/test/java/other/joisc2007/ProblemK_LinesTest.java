package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemK_LinesTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 4 6 4\n" + "0 0 6 6\n" + "1 0 1 6\n" + "0 6 6 0", "11");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Lines");
	}
}
