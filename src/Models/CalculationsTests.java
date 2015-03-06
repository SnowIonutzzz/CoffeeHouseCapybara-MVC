package Models;
import Controllers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

// These JUnit tests serve to prove that the redeclaration-calculations work.
// The tests may also serve to show how the RunwayArea objects and Obstruction objects can be used within the system.

public class CalculationsTests {

	@Test
	public void calculationTest1a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(741.0, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(1214.0, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTest1b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 4.78, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(240.0, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(1715.0, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTest2a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		assertEquals(1705.0, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(1705.0, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(1735.0, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest2b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 3.2, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		assertEquals(1705.0, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(1705.0, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(1735.0, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest3a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(1715.0, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest3b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(1715.0, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest4a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		assertEquals(741.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(1210.0, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(1210.0, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(1210.0, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest4b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 4.78, 10.0, 2050.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(1711.0, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(1711.0, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(1711.0, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest5a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(741.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(2229.0, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest5b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 4.3, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest6a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 4.3, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(240.0, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTest6b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(240.0, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTest7a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(2570.0, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(2570.0, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(2600.0, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest7b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.3, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(2570.0, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(2570.0, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(2600.0, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest8a() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		assertEquals(741.0, ra.getParametersApproachFromRight().resa, 0.0001);
		assertEquals(2229.0, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(2229.0, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(2229.0, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest8b() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 4.3, 10.0, 25.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		assertEquals(240.0, ra.getParametersApproachFromRight().resa, 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(2730.0, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest9() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, -600.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(ra.getOriginalParameters().tora, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(ra.getOriginalParameters().toda, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(ra.getOriginalParameters().asda, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest10() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(300.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(ra.getOriginalParameters().tora, ra.getParametersApproachFromLeft().tora, 0.0001);
		assertEquals(ra.getOriginalParameters().toda, ra.getParametersApproachFromLeft().toda, 0.0001);
		assertEquals(ra.getOriginalParameters().asda, ra.getParametersApproachFromLeft().asda, 0.0001);
	}

	@Test
	public void calculationTest11() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, -600.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(ra.getOriginalParameters().resa, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest12() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(ra.getOriginalParameters().resa, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest13() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, -600.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(ra.getOriginalParameters().tora, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(ra.getOriginalParameters().toda, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(ra.getOriginalParameters().asda, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest14() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		// assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		assertEquals(ra.getOriginalParameters().tora, ra.getParametersApproachFromRight().tora, 0.0001);
		assertEquals(ra.getOriginalParameters().toda, ra.getParametersApproachFromRight().toda, 0.0001);
		assertEquals(ra.getOriginalParameters().asda, ra.getParametersApproachFromRight().asda, 0.0001);
	}

	@Test
	public void calculationTest15() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, -600.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(ra.getOriginalParameters().resa, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTest16() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		assertEquals(ra.getOriginalParameters().resa, ra.getParametersApproachFromRight().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromRight().lda, 0.0001);
	}

	@Test
	public void calculationTestX1() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 1500.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTestX2() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(250.0));
		Obstruction o = new Obstruction(9.0, 15.0, 10.0, 2050.0, 500.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		assertEquals(240.0, ra.getParametersApproachFromLeft().resa, 0.0001);
		// assertEquals(1244.0, ra.parametersLandTakeOffFromRight.ldaEnd,
		// 0.0001);
		assertEquals(ra.getOriginalParameters().lda, ra.getParametersApproachFromLeft().lda, 0.0001);
	}

	@Test
	public void calculationTest17() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromRight();
		boolean exceptionCaught = false;
		try {
			ra.getOriginalParameters();
			ra.getParametersApproachFromLeft();
		} catch (Exception e) {
			exceptionCaught = true;
		}
		assertEquals(true, exceptionCaught);
	}

	@Test
	public void calculationTest18() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromRight();
		boolean exceptionCaught = false;
		try {
			ra.getOriginalParameters();
			ra.getParametersApproachFromLeft();
		} catch (Exception e) {
			exceptionCaught = true;
		}
		assertEquals(true, exceptionCaught);
	}

	@Test
	public void calculationTest19() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForLandingFromLeft();
		boolean exceptionCaught = false;
		try {
			ra.getOriginalParameters();
			ra.getParametersApproachFromRight();
		} catch (Exception e) {
			exceptionCaught = true;
		}
		assertEquals(true, exceptionCaught);
	}

	@Test
	public void calculationTest20() throws Exception {
		RunwayArea ra = new RunwayArea(00, 2000.0, 3090.0, 3090.0, 200.0, 30.0, 100.0, 3060.0, 2990.0, 1000.0, 0.0, 30.0, 3060.0, 3090.0);
		ra.setPlaneTakingOff(new Plane(400.0));
		Obstruction o = new Obstruction(9.0, 4.0, 10.0, 4000.0, 1000.0, 4.0, 0.0);
		ra.addObstruction(o);
		ra.redeclareForTakeOffFromLeft();
		boolean exceptionCaught = false;
		try {
			ra.getOriginalParameters();
			ra.getParametersApproachFromRight();
		} catch (Exception e) {
			exceptionCaught = true;
		}
		assertEquals(true, exceptionCaught);
	}

}
