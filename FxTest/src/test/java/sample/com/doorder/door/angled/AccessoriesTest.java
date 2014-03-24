package sample.com.doorder.door.angled;

import org.junit.Assert;
import org.junit.Before;
import sample.com.doorder.door.Accessories;

public class AccessoriesTest extends Assert {

	private static final double DELTA = 1e-12;

	private Accessories accessories;

	@Before
	public void setUp() throws Exception {
		accessories = new Accessories();
	}

//	@Test
//	public void testCalcSpyHolder() throws Exception {
//		accessories.calcSpyHolder(1);
//		assertEquals(100, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcSpyHolder(2);
//		assertEquals(200, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcSpyHolder(3);
//		assertEquals(300, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcSpyHolder(0);
//		assertEquals(0, accessories.getTotalAccessoriesPrice(), DELTA);
//	}
//
//	@Test
//	public void testCalcTopLocker() throws Exception {
//		accessories.calcTopLocker(1);
//		assertEquals(100, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcTopLocker(2);
//		assertEquals(200, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcTopLocker(3);
//		assertEquals(300, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcTopLocker(0);
//		assertEquals(0, accessories.getTotalAccessoriesPrice(), DELTA);
//	}
//
//	@Test
//	public void testCalcBottomLocker() throws Exception {
//		accessories.calcBottomLocker(1);
//		assertEquals(100, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcBottomLocker(2);
//		assertEquals(200, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcBottomLocker(3);
//		assertEquals(300, accessories.getTotalAccessoriesPrice(), DELTA);
//		accessories.calcBottomLocker(0);
//		assertEquals(0, accessories.getTotalAccessoriesPrice(), DELTA);
//	}
}
