package sample.com.doorder.door.fireproof;

import sample.com.doorder.door.Door;
import sample.com.doorder.door.types.InnerDecorationType;
import sample.com.doorder.door.types.OuterDecorationType;
import sample.com.doorder.door.types.PlatbandType;

public interface FireProofDoor extends Door {

	void calcMetalFrameParts();

	void calcInnerMetalList();

	void calcOuterMetalList();

	void calcHinge();

	void calcOgrask();

	void calcDryWall();

	void calcMineralWool();

	void calcSeal();

	void calcOuterDecoration(OuterDecorationType outerDecorationType);

	void calcInnerDecoration(InnerDecorationType innerDecorationType);

	void calcPlatband(PlatbandType platbandType);

	void calcAccessories();
}
