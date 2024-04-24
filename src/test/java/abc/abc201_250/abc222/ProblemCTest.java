package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "GCP\n" + "PPP\n" + "CCC\n" + "PPC", "3\n" + "1\n" + "2\n" + "4");
	}

	@Test
	void case2() {
		check("2 2\n" + "GC\n" + "PG\n" + "CG\n" + "PP", "1\n" + "2\n" + "3\n" + "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/C");
	}
}
