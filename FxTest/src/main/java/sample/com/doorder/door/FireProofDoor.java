package sample.com.doorder.door;

public interface FireProofDoor {

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
