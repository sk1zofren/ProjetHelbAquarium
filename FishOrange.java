public class FishOrange extends Fish {

  public FishOrange() {
    super(1, 50);

  }

  @Override
  public void update() {

    super.update();
    target_x = newTarget_X;
    target_y = newTarget_Y;

    if (touchOb) { //when the orange fish touches an obstacle he changes the direction
      newTarget_X = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getHeights())));
      newTarget_Y = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts())));
      touchOb = false;
    }

  }
}