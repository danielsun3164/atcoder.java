package other.joi2007yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 4\n" + "3\n" + "2 2\n" + "2 3\n" + "4 2", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007yo/F");
	}
}
