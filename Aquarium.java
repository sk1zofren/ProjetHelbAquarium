import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Aquarium extends JPanel implements ActionListener {

  private final static int LENGHT = 500; // Aquarium length
  private final static int HEIGHT = 600; // Aquarium height 
  private final static int DOT_SIZE = 1; // the size of the small grid tiles, each step 
  private static int DELAY = 5; // number of milliseconds elapsed between each action (frame rate)
  static String temperature = "tied"; // Aquarium temperature
  static int numberOfDeco = 0; // number of Deco
  private Timer timer;
  static ArrayList < Fish > listFish = new ArrayList < Fish > (); // fish list
  static ArrayList < Fish > listFishPrey = new ArrayList < Fish > (); // fish prey list
  static ArrayList < Fish > listFishFriend = new ArrayList < Fish > (); // fish friend list
  static ArrayList < Fish > listFishRed = new ArrayList < Fish > (); // fish red list
  static ArrayList < Bug > listBug = new ArrayList < Bug > (); //  bug list
  static ArrayList < Rosa > listRosa = new ArrayList < Rosa > (); //  past pink list
  static ArrayList < Decoration > listDeco = new ArrayList < Decoration > (); // list of deco
  static ArrayList < Past > listPast = new ArrayList < Past > (); // past list

  private Image ladyBugImage;
  private Image cockroachBugImage;
  private Image butterFlyBugImage;
  private Image decoImage;
  private Image pastImage;
  private Image rosaImage; 

  public static int getheight() { // method to have the size of the aquarium
    return LENGHT / DOT_SIZE;
  }

  public static int getLenghts() { // method to have the lenght of the aquarium
    return LENGHT;
  }

  public static int getHeights() { // method to have the height of the aquarium
    return HEIGHT;
  }

  public Aquarium() {
    initBoard();
  }

  private void initBoard() {

    addKeyListener(new TAdapter());
    if (temperature.equals("cold")) {
      setBackground(Color.yellow);
    } else if (temperature.equals("hard")) {
      setBackground(Color.green);
    } else {
      setBackground(Color.black);
    }
    setFocusable(true);
    setPreferredSize(new Dimension(LENGHT, HEIGHT));
    initGame();
  }

  private void addFish() { // method to add fish in the aquarium

    listFish.add(new FishBlue("Images/FishOrange.png", 0, 10));
    listFish.add(new FishPurple("Images/FishRed.png", 0, 10));
    listFish.add(new FishRed( "Images/FishRed.png", 0, 10));
    listFish.add(new FishOrange( "Images/FishRed.png", 0, 10));

  }

  private void addDeco() { // method to add deco in the aquarium
    for (int i = 0; i < 0; i++) {
      listDeco.add(new Decoration());
      numberOfDeco++;
    }
  }

  private void addBug() { // method to add bug in the aquarium
    for (int i = 0; i < 0; i++) {
      listBug.add(new Bug("Butterfly"));
      listBug.add(new Bug("Cockroach"));
      listBug.add(new Bug("LadyBug"));
    }
  }

  private void addPast() { // method to add past in the aquarium
    for (int i = 0; i < 0; i++) {
      listPast.add(new Past());
    }
  }

  private void addRosa() { // method to add pink past in the aquarium
    for (int i = 0; i < 100; i++) {
      listRosa.add(new Rosa());
    }
  }

  public static ArrayList < Fish > getlistFishPrey() {
    for (int i = 0; i < listFish.size(); i++) {
      if (listFish.get(i).getId() != 4) {
        listFishPrey.add(listFish.get(i));
      }
    }
    return listFishPrey;
  }

  public static ArrayList < Fish > getlistFishFriend() {
    for (int i = 0; i < listFish.size(); i++) {
      if (listFish.get(i).getId() != 4 && listFish.get(i).getId() != 1) {
        listFishFriend.add(listFish.get(i));
      }
    }
    return listFishFriend;
  }

  public static ArrayList < Fish > getlistFishRed() {
    for (int i = 0; i < listFish.size(); i++) {
      if (listFish.get(i).getId() == 4) {
        listFishRed.add(listFish.get(i));
      }
    }
    return listFishRed;
  }

  public static ArrayList < Fish > getlistFish() {
    return listFish;
  }

  public static int getPas() {  
    return DOT_SIZE;
  }

  private void initGame() {
    addFish();
    addDeco();
    addBug();
    addPast();
    addRosa();
    getlistFishPrey();
    getlistFishFriend();
    getlistFishRed();
    loadImages();
    timer = new Timer(DELAY, this);
    timer.start();

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doUpdate();
    doDrawing(g);
  }

  private void doUpdate() {
    for (int i = 0; i < listFish.size(); i++) {
      listFish.get(i).update();
    }

    for (int i = 0; i < listDeco.size(); i++) {
      listDeco.get(i).update();
    }

    for (int i = 0; i < listBug.size(); i++) {
      listBug.get(i).update();
    }

    for (int i = 0; i < listPast.size(); i++) {
      listPast.get(i).update();
    }

    for (int i = 0; i < listRosa.size(); i++) {
      listRosa.get(i).update();
    }
  }

  private void loadImages() {

    ImageIcon iia = new ImageIcon("Image/ladyBug.png");
        ladyBugImage = iia.getImage();
    
    ImageIcon iib = new ImageIcon("Image/cockroach.png");
        cockroachBugImage = iib.getImage();
    
    ImageIcon iic = new ImageIcon("Image/pap.png");
        butterFlyBugImage = iic.getImage();

    ImageIcon iid = new ImageIcon("Image/Dec.png");
        decoImage = iid.getImage();

    ImageIcon iie = new ImageIcon("Image/past.png");
        pastImage = iie.getImage();
    
    ImageIcon iif = new ImageIcon("Image/rose.png");
       rosaImage = iif.getImage();
}

  private void doDrawing(Graphics g) {
    for (int i = 0; i < listFish.size(); i++) {
      g.drawImage(listFish.get(i).getFish(), listFish.get(i).getX() * DOT_SIZE, listFish.get(i).getY() * DOT_SIZE, this);
    }

    for (int i = 0; i < listDeco.size(); i++) {
      g.drawImage(decoImage, listDeco.get(i).getX() * DOT_SIZE, listDeco.get(i).getY() * DOT_SIZE, this);
    }

    for (int i = 0; i < listBug.size(); i++) {
        if(listBug.get(i).getName().equals("LadyBug")){
      g.drawImage(ladyBugImage, listBug.get(i).getX() * DOT_SIZE, listBug.get(i).getY() * DOT_SIZE, this);
        } else if (listBug.get(i).getName().equals("Cockroach")){
            g.drawImage(cockroachBugImage, listBug.get(i).getX() * DOT_SIZE, listBug.get(i).getY() * DOT_SIZE, this);
        } else if (listBug.get(i).getName().equals("Butterfly")){
            g.drawImage(butterFlyBugImage, listBug.get(i).getX() * DOT_SIZE, listBug.get(i).getY() * DOT_SIZE, this);
        }
    }

    for (int i = 0; i < listPast.size(); i++) {
      g.drawImage(pastImage, listPast.get(i).getX() * DOT_SIZE, listPast.get(i).getY() * DOT_SIZE, this);
    }

    for (int i = 0; i < listRosa.size(); i++) {
      g.drawImage(rosaImage, listRosa.get(i).getX() * DOT_SIZE, listRosa.get(i).getY() * DOT_SIZE, this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();
  }

  public static void removeFromListFish(Fish fish) {
    listFish.remove(fish);
  }

  public static void removeFromListRosa(Rosa rosa) {
    listRosa.remove(rosa);
  }

  public static void removeFromListFishPray(Fish fish) {
    listFishPrey.remove(fish);
  }

  public static void removeFromListBug(Bug bug) {
    listBug.remove(bug);
  }

  public static void removeFromListPast(Past past) {
    listPast.remove(past);
  }
  public static void addFromListFish(Fish fish) {
    listFish.add(fish);
  }

  private class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {

      int key = e.getKeyCode();

      if ((key == KeyEvent.VK_0)) {  
        listFish.removeAll(listFish);
        listBug.removeAll(listBug);
        listDeco.removeAll(listDeco);
        listPast.removeAll(listPast);
        doUpdate();
        numberOfDeco = 0;
        setBackground(Color.black);
        temperature = "tiede";
        initGame();

      }

      if ((key == KeyEvent.VK_1)) {
        setBackground(Color.yellow);
        temperature = "cold";
      }

      if ((key == KeyEvent.VK_2)) {
        setBackground(Color.black);
        temperature = "tiede";
      }

      if ((key == KeyEvent.VK_3)) {
        setBackground(Color.green);
        temperature = "hard";
      }

      if ((key == KeyEvent.VK_4)) {
        addBug();
      }

      if ((key == KeyEvent.VK_5)) { 
        addPast();
      }

      if ((key == KeyEvent.VK_6)) { // TODO fonctionne pas 

      }

      if ((key == KeyEvent.VK_7)) { // TODO fonctionne pas 

      }

      if ((key == KeyEvent.VK_8)) { // TODO fonctionne pas 

      }

      if ((key == KeyEvent.VK_9)) {
        int x = (int)(1 + (Math.random() * (4)));
        switch (x) {
        case 1:
          listFish.add(new FishBlue("Images/FishRed.png", 0, 10));
          break;
        case 2:
          listFish.add(new FishRed( "Images/FishRed.png", 0, 10));
          break;
        case 3:
          listFish.add(new FishOrange("Images/FishRed.png", 0, 10));
          break;
        case 4:
          listFish.add(new FishPurple("Images/FishRed.png", 0, 10));
          break;

        default:
          break;
        }
      }
      if ((key == KeyEvent.VK_R)) {
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != 4) {
            Aquarium.listFish.get(j).move = false;
          }
        }
      }
      if ((key == KeyEvent.VK_B)) {
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != 2) {
            Aquarium.listFish.get(j).move = false;
          }
        }
      }

      if ((key == KeyEvent.VK_M)) {
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != 3) {
            Aquarium.listFish.get(j).move = false;
          }
        }
      }

      if ((key == KeyEvent.VK_O)) {
        for (int j = 0; j < Aquarium.listFish.size(); j++) {
          if (Aquarium.listFish.get(j).getId() != 1) {
            Aquarium.listFish.get(j).move = false;
          }
        }
      }
    }

  }
}