package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemI_CircuitTest extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + "3\n" + "1\n" + "2", "2" + LF + "3" + LF + "1");
	}

	@Test
	void case2() {
		check("4 4\n" + "2\n" + "1\n" + "4\n" + "3", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Circuit");
	}
}
