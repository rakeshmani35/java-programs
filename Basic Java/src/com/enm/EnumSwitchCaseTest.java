package com.enm;

enum RatingEnum {

	EXCEEDS_EXPECTATIONS(6), EXCELLENT(5), SUPERB(4), NICE(3), NEEDS_IMPROVEMENT(2), POOR(1);

	private int value;

	public int getRating() {
		return value;
	}

	private RatingEnum(int value) {
		this.value = value;
	}
}

public class EnumSwitchCaseTest {

	public static void main(String[] args) {

		RatingEnum myRaiting = RatingEnum.valueOf(RatingEnum.class, "EXCEEDS_EXPECTATIONS");

		switch (myRaiting) {
		case EXCEEDS_EXPECTATIONS:
			System.out.println("Rating Value ::" + RatingEnum.EXCEEDS_EXPECTATIONS.getRating());
			break;

		case EXCELLENT:
			System.out.println("Rating Value ::" + RatingEnum.EXCELLENT.getRating());
			break;
		case SUPERB:
			System.out.println("Rating Value ::" + RatingEnum.SUPERB.getRating());
			break;
		case NICE:
			System.out.println("Rating Value ::" + RatingEnum.NICE.getRating());
			break;
		case NEEDS_IMPROVEMENT:
			System.out.println("Rating Value ::" + RatingEnum.NEEDS_IMPROVEMENT.getRating());
			break;
		case POOR:
			System.out.println("Rating Value ::" + RatingEnum.POOR.getRating());
			break;
		default:
			break;
		}

	}

}
