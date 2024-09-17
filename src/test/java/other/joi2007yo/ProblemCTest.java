package other.joi2007yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("MRL", "JOI");
	}

	@Test
	void case2() {
		check("FURDWLD", "CROATIA");
	}

	@Test
	void case3() {
		check("ABC", "XYZ");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007yo/C");
	}
}
