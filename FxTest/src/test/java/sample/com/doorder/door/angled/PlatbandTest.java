package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlatbandTest extends Assert {

	private static final double DELTA = 1e-12;
	private Platband platband;

	@Before
	public void setUp() throws Exception {
		platband = new Platband();
	}

	@Test
	public void testCalcWoodenPlatband() throws Exception {
		platband.calcWoodenPlatband(1000, 2000, this.getClass());
		assertEquals(55.00, platband.getTotalPlatbandPrice(), DELTA);
	}

	@Test
	public void testCalcMetalPlatbandPaintingPF() throws Exception {
		platband.calcMetalPlatbandPaintingPF(1000, 2000, this.getClass());
		assertEquals(120.50, platband.getTotalPlatbandPrice(), DELTA);
	}

	@Test
	public void testCalcMetalPlatbandPaintingShagreen() throws Exception {
		platband.calcMetalPlatbandPaintingShagreen(1000, 2000, this.getClass());
		assertEquals(134.50, platband.getTotalPlatbandPrice(), DELTA);
	}

	@Test
	public void testCalcMetalPlatbandPaintingAntic() throws Exception {
		platband.calcMetalPlatbandPaintingAntic(1000, 2000, this.getClass());
		assertEquals(138.00, platband.getTotalPlatbandPrice(), DELTA);
	}

	@Test
	public void testCalcMdf10Platband() throws Exception {
		platband.calcMdf10Platband(1000, 2000, 70, this.getClass());
		assertEquals(35, platband.getTotalPlatbandPrice(), DELTA);
	}

	@Test
	public void testCalcMdf16Platband() throws Exception {
		platband.calcMdf16Platband(1000, 2000, 70, this.getClass());
		assertEquals(70, platband.getTotalPlatbandPrice(), DELTA);
	}
}
