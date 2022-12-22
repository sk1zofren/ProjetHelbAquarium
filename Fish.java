import java.util.ArrayList;
import java.util.Collections;

public abstract class Fish extends GameObjectElement {

  private int id = 0; // id which identifies each fish 
  protected int target_x; // fish target x coordinate
  protected int target_y; // fish target y coordinate
  protected int newTarget_X; // new fish target x coordinate
  protected int newTarget_Y; // new fish target y coordinate
  protected boolean touchOb = false; // boolean that is activated if an edge is touched
  protected int speed; // speed of fish
  protected int speedMax = 99; // max speed of fish
  protected int speedBasic = 50; // basic speed of fish
  protected int cpt = speed; // counter for the timer
  protected int limit = 100; // limit for the timer
  protected boolean move = true; // when it is equal to true, the fish can move
  private int screenBorder = 2; // screen border
  private int borderObstacle = 15; // the outline of the obstacles
  static int screenLimitLeft = 20; // the screen limit left
  static boolean reprod = false; // boolean to active reproduction mode
  static boolean insect = false; // boolean to active insect mode
  static boolean past = false; // boolean to active past mode

  public Fish(int id, int speed) {

    this.id = id;
    this.speed = speed;
    newTarget_X = (int)(screenLimitLeft + (Math.random() * (Aquarium.getLenghts()))); // random target
    newTarget_Y = (int)(screenLimitLeft + (Math.random() * (Aquarium.getLenghts()))); // random target

  }

  public int getId() {
    return id;
  }

  private void move() { // the method how to move fish

    ArrayList < Integer > x_moveOptions = new ArrayList < Integer > ();
    ArrayList < Integer > y_moveOptions = new ArrayList < Integer > ();
    ArrayList < Double > distances = new ArrayList < Double > ();

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        int test_pos_x = pos_x + i * Aquarium.getPas();
        int test_pos_y = pos_y + j * Aquarium.getPas();
        if (isValidPosition(test_pos_x, test_pos_y)) {
          x_moveOptions.add(test_pos_x);
          y_moveOptions.add(test_pos_y);
        }
      }
    }

    for (int i = 0; i < x_moveOptions.size(); i++) {
      Double distance = getDistance(target_x, target_y, x_moveOptions.get(i), y_moveOptions.get(i));
      distances.add(distance);
    }

    double min = Collections.min(distances);
    int min_index = distances.indexOf(min);
    pos_x = x_moveOptions.get(min_index);
    pos_y = y_moveOptions.get(min_index);
  }

  private boolean isValidPosition(int pos_x, int pos_y) { // to find a valid position

    boolean res = true;
    if (pos_y >= Aquarium.getHeights() - screenBorder) {
      res = false;
    }

    if (pos_y < screenBorder) {
      res = false;
    }

    for (int j = 0; j < Aquarium.listDeco.size(); j++) {

      if (pos_y >= Aquarium.listDeco.get(j).getY() - borderObstacle && pos_y <= Aquarium.listDeco.get(j).getY() + borderObstacle && pos_x == Aquarium.listDeco.get(j).getX() + borderObstacle) {
        res = false;
        touchOb = true;
      }

      if (pos_y >= Aquarium.listDeco.get(j).getY() - borderObstacle && pos_y <= Aquarium.listDeco.get(j).getY() + borderObstacle && pos_x == Aquarium.listDeco.get(j).getX() - borderObstacle) {
        res = false;
        touchOb = true;
      }

      if (pos_x >= Aquarium.listDeco.get(j).getX() - borderObstacle && pos_x <= Aquarium.listDeco.get(j).getX() + borderObstacle && pos_y == Aquarium.listDeco.get(j).getY() + borderObstacle) {
        res = false;
        touchOb = true;
      }

      if (pos_x >= Aquarium.listDeco.get(j).getX() - borderObstacle && pos_x <= Aquarium.listDeco.get(j).getX() + borderObstacle && pos_y == Aquarium.listDeco.get(j).getY() - borderObstacle) {
        res = false;
        touchOb = true;
      }

    }

    if (pos_x >= Aquarium.getLenghts() - screenBorder) {
      res = false;
    }

    if (pos_x < screenBorder) {
      res = false;
    }
    return res;
  }

  private double getDistance(int pos_x0, int pos_y0, int pos_x1, int pos_y1) {
    int x_dist = pos_x1 - pos_x0;
    int y_dist = pos_y1 - pos_y0;
    return Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
  }

  private void reproduction() { //the method of reproduction 

    for (int j = 0; j < Aquarium.listFish.size(); j++) {
      if (this.hashCode() != Aquarium.listFish.get(j).hashCode() && Aquarium.listFish.get(j).getId() == this.getId() && Aquarium.listFish.get(j).pos_x == this.pos_x && Aquarium.listFish.get(j).pos_y == this.pos_y) {
        Fish fish = this;
        Aquarium.removeFromListFish(fish);
        Aquarium.removeFromListFish(Aquarium.listFish.get(j));

        for (int i = 0; i < 3; i++) {
          if (this.id == 1) {
            Aquarium.listFish.add((new FishOrange()));
          } else if (this.id == 2) {
            Aquarium.listFish.add((new FishBlue()));
          } else if (this.id == 3) {
            Aquarium.listFish.add((new FishPurple()));
          } else if (this.id == 4) {
            Aquarium.listFish.add((new FishRed()));
          }
        }

      }
    }
  }

  public void reproductionMod() { //method to find the nearest fish for reproduction
    double startDepart = Integer.MAX_VALUE;
    for (int i = 0; i < Aquarium.listFish.size(); i++) {
      int x_dist = Aquarium.listFish.get(i).pos_x - pos_x;
      int y_dist = Aquarium.listFish.get(i).pos_y - pos_y;
      double distance = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
      if (distance < startDepart && Aquarium.listFish.get(i).hashCode() != this.hashCode() && this.id == Aquarium.listFish.get(i).id) {
        this.newTarget_X = Aquarium.listFish.get(i).pos_x;
        this.newTarget_Y = Aquarium.listFish.get(i).pos_y;
        Aquarium.listFish.get(i).newTarget_X = this.newTarget_X;
        Aquarium.listFish.get(i).newTarget_Y = this.newTarget_Y;
        startDepart = distance;

      }
    }
  }
  public void pastMod() { //method to find the nearest past
    double startDepart = Integer.MAX_VALUE;
    for (int i = 0; i < Aquarium.listPast.size(); i++) {
      int x_dist = Aquarium.listPast.get(i).pos_x - pos_x;
      int y_dist = Aquarium.listPast.get(i).pos_y - pos_y;
      double distance = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
      if (distance < startDepart) {
        newTarget_X = Aquarium.listPast.get(i).pos_x;
        newTarget_Y = Aquarium.listPast.get(i).pos_y;
        startDepart = distance;

      }
    }
  }

  public void insectivorMod() { //method to find the nearest fish
    double startDepart = Integer.MAX_VALUE;
    for (int i = 0; i < Aquarium.listFish.size(); i++) {
      int x_dist = Aquarium.listFish.get(i).pos_x - pos_x;
      int y_dist = Aquarium.listFish.get(i).pos_y - pos_y;
      double distance = Math.sqrt(Math.pow(x_dist, 2) + Math.pow(y_dist, 2));
      if (distance < startDepart && Aquarium.listFish.get(i).hashCode() != this.hashCode()) {
        this.newTarget_X = Aquarium.listFish.get(i).pos_x;
        this.newTarget_Y = Aquarium.listFish.get(i).pos_y;
        Aquarium.listFish.get(i).newTarget_X = this.newTarget_X;
        Aquarium.listFish.get(i).newTarget_Y = this.newTarget_Y;
        startDepart = distance;

      }
    }
  }

  public void update() {

    if (move) {
      for (int i = 0; i < Aquarium.listFish.size(); i++) {
        if (Aquarium.listFish.get(i).cpt > limit) {
          Aquarium.listFish.get(i).move();
          Aquarium.listFish.get(i).cpt = Aquarium.listFish.get(i).speed;
        } else {
          cpt++;
        }
      }

    }
    if (reprod) {
      reproductionMod();
    }
    if (insect) {
      insectivorMod();
    }

    reproduction();

    if (past) {
      pastMod();
    }

  }

}