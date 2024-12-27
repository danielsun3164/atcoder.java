package other.joi2008yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("JOIJOI", "2" + LF + "0");
	}

	@Test
	void case2() {
		check("JOIOIOIOI", "1" + LF + "3");
	}

	@Test
	void case3() {
		check("JOIOIJOINXNXJIOIOIOJ", "2" + LF + "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2008yo/B");
	}
}
