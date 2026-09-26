package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("ABC\n" + "4\n" + "0 1\n" + "1 1\n" + "1 3\n" + "1 6", "A" + LF + "B" + LF + "C" + LF + "B");
	}

	@Test
	void case2() {
		check("CBBAACCCCC\n" + "5\n" + "57530144230160008 659279164847814847\n"
				+ "29622990657296329 861239705300265164\n" + "509705228051901259 994708708957785197\n"
				+ "176678501072691541 655134104344481648\n" + "827291290937314275 407121144297426665",
				"A" + LF + "A" + LF + "C" + LF + "A" + LF + "A");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/D");
	}
}
