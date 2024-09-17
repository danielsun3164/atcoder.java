package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE_FermatTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5", "9");
	}

	@Test
	void case2() {
		check("19\n" + "21", "487");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Fermat");
	}
}
