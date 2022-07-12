package abc.abc001_050.abc042;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1000 8\n" + "1 3 4 5 6 7 8 9", "2000");
	}

	@Test
	void case2() {
		check("9999 1\n" + "0", "9999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC058_ABC042/C");
	}
}
