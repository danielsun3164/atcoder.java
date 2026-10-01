package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "16\n" + "1\n" + "123456789012\n" + "1000000000000000000",
				"5" + LF + "1" + LF + "4555793983" + LF + "23561347048791096");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/G");
	}
}
