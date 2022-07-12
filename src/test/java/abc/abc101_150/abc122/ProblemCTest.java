package abc.abc101_150.abc122;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("8 3\n" + "ACACTACG\n" + "3 7\n" + "2 3\n" + "1 8", "2" + LF + "0" + LF + "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC122/C");
	}
}
