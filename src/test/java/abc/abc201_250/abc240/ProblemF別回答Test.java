package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 7\n" + "-1 2\n" + "2 3\n" + "-3 2\n" + "10 472\n" + "-4 12\n" + "1 29\n" + "2 77\n" + "-1 86\n"
				+ "0 51\n" + "3 81\n" + "3 17\n" + "-2 31\n" + "-4 65\n" + "4 23\n" + "1 1000000000\n" + "4 1000000000",
				"4" + LF + "53910" + LF + "2000000002000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/F");
	}
}
