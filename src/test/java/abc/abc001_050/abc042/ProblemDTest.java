package abc.abc001_050.abc042;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3 1 1", "2");
	}

	@Test
	void case2() {
		check("10 7 3 4", "3570");
	}

	@Test
	void case3() {
		check("100000 100000 99999 99999", "1");
	}

	@Test
	void case4() {
		check("100000 100000 44444 55555", "738162020");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC058_ABC042/D");
	}
}
