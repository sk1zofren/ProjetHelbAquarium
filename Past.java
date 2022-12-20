public class Past extends GameObjectElement {

  private static int startChrono = 10000;
  static int borderPast = 6;
  private static int chrono = startChrono; // chrono for timer

  public Past() {

  }

  public int getDuree() {
    return chrono;
  }

  public void update() {

    chrono--;
    if (chrono < 0) { // when the time is finish the fish can move
      for (int j = 0; j < Aquarium.listFish.size(); j++) {
        Aquarium.listFish.get(j).move = true;
      }
    }
    for (int i = 0; i < Aquarium.listFish.size(); i++) { // when a fish touch a past, the auther fish can't move
      if (Aquarium.listFish.get(i).pos_x > getX() - borderPast && Aquarium.listFish.get(i).pos_x < getX() + borderPast && Aquarium.listFish.get(i).pos_y > getY() - borderPast && Aquarium.listFish.get(i).pos_y < getY() + borderPast) {
        Past past = this;
        Aquarium.removeFromListPast(past);
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != Aquarium.listFish.get(i).getId())
            Aquarium.listFish.get(j).move = false;
          chrono = startChrono;
        }

      }

    }

  }

}