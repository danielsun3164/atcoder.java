package abc168;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	private static final double TOLERANCE = 0.000000001d;

	@Test
	void case1() throws IOException {
		in.input("3 4 9 0");
		ProblemC.main(null);
		assertResultIsAbout(5.0d, TOLERANCE);
	}

	@Test
	void case2() throws IOException {
		in.input("3 4 10 40");
		ProblemC.main(null);
		assertResultIsAbout(4.56425719433005567605d, TOLERANCE);
	}
}
