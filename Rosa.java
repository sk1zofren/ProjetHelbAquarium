public class Rosa extends GameObjectElement {

  public Rosa() {

  }

  public void update() {

    for (int i = 0; i < Aquarium.listFish.size(); i++) { // when a fish touch a pink past fish appears in the random position
      if (Aquarium.listFish.get(i).pos_x > getX() - Past.borderPast && Aquarium.listFish.get(i).pos_x < getX() + Past.borderPast && Aquarium.listFish.get(i).pos_y > getY() - Past.borderPast && Aquarium.listFish.get(i).pos_y < getY() + Past.borderPast) {
        Rosa rosa = this;
        Aquarium.removeFromListRosa(rosa);
        Aquarium.listFish.get(i).pos_x = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts()-Fish.screenLimitLeft)));
        Aquarium.listFish.get(i).pos_y = (int)(Fish.screenLimitLeft + (Math.random() * (Aquarium.getLenghts())));
      }
    }

  }

}