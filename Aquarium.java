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

public class Aquarium extends JPanel implements ActionListener {

    private final static int LENGHT = 500; // longueur de l'Aquarium
    private final static int HEIGHT = 600; // largeur de l'Aquarium 
    private final static int DOT_SIZE = 1;  // la taille des petits carreaux de la grille, chaque pas 
    private static int DELAY = 5; // nombre de miliseconde ecolouer entre chaque action ( vitesse d'image )
    static String temperature = "tied";
    static int numberOfDeco=0;
    private Timer timer; 
    static  ArrayList<Fish> listFish = new ArrayList<Fish>();
    static  ArrayList<Fish> listFishPrey = new ArrayList<Fish>();
    static  ArrayList<Fish> listFishFriend = new ArrayList<Fish>();
    static  ArrayList<Fish> listFishRed = new ArrayList<Fish>();
    static  ArrayList<Bug> listBug = new ArrayList<Bug>();
    static  ArrayList<Rosa> listRosa = new ArrayList<Rosa>();
    static ArrayList<Decoration> listDeco = new ArrayList<Decoration>();
    
    
    static ArrayList<Past> listPast = new ArrayList<Past>();

    public static int getTaille(){
        return LENGHT/DOT_SIZE;
    }

    public static int getLenghts(){
        return LENGHT;
    }

    public static int getHeights(){
        return HEIGHT;
    }
  

    public Aquarium() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        if(temperature.equals("cold")){
            setBackground(Color.yellow);
        }else if(temperature.equals("hard")){
            setBackground(Color.green);
        }else{
            setBackground(Color.black);
        } 
        setFocusable(true);
        setPreferredSize(new Dimension(LENGHT, HEIGHT));
        initGame();
    }

    private void addFish(){   
                     
            
            listFish.add(new FishBlue("blue", "Images/FishOrange.png",0, 10)); 
            listFish.add(new FishPurple("purple","Images/FishRed.png",0, 10));
            listFish.add(new FishRed("red", "Images/FishRed.png",0, 10)); 
            listFish.add(new FishOrange("orange","Images/FishRed.png",0, 10));
        
    }

    private void addDeco(){
        for (int i = 0; i <1 ; i++) {
            listDeco.add(new Decoration("Images/rec.png"));
          
            
            numberOfDeco++;
        }
    }

    private void addBug(){
        for (int i = 1; i < 0; i++) {
            listBug.add(new Bug("Image/pap.png","Butterfly")); 
            listBug.add(new Bug("Image/cockroach.png","Cockroach"));
            listBug.add(new Bug("Image/ladyBug.png","LadyBug"));
                           
        }
    }

    private void addPast(){
        for (int i = 0; i < 0; i++) {
            listPast.add(new Past("Image/past.png"));
        } 
    }

    private void addRosa(){
        for (int i = 0; i < 0; i++) {
            listRosa.add(new Rosa("Image/rose.png"));
        } 
    }


    public static ArrayList<Fish> getlistFishPrey() {
        for (int i = 0; i < listFish.size(); i++) {
            if(listFish.get(i).getId()!=4){
                listFishPrey.add(listFish.get(i));               
            } 
        }
        return listFishPrey;
    }

    public static ArrayList<Fish> getlistFishFriend() {
        for (int i = 0; i < listFish.size(); i++) {
            if(listFish.get(i).getId()!=4 && listFish.get(i).getId()!=1 ){
                listFishFriend.add(listFish.get(i));               
            } 
        }
        return listFishFriend;
    }

    public static ArrayList<Fish> getlistFishRed() {
        for (int i = 0; i < listFish.size(); i++) {
            if(listFish.get(i).getId() == 4){
                listFishRed.add(listFish.get(i));               
            } 
        }
        return listFishRed;
    }

    public static ArrayList<Fish> getlistFish() {
        return listFish;
    }

    public static int getSpeed(){ // methode non indispensable 
        return DELAY;
    }

    public static int getPas(){ // methode non indispensable 
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
        for(int i =0; i<listFish.size(); i++){      
            listFish.get(i).update(); 
        }

        for(int i =0; i<listDeco.size(); i++){      
            listDeco.get(i).update(); 
        }

        for(int i =0; i<listBug.size(); i++){      
            listBug.get(i).update(); 
            }

        for(int i =0; i<listPast.size(); i++){      
            listPast.get(i).update(); 
        }

        for(int i =0; i<listRosa.size(); i++){      
            listRosa.get(i).update(); 
        }
    }

    private void doDrawing(Graphics g) { 
        for(int i =0; i<listFish.size(); i++){ 
            g.drawImage(listFish.get(i).getFish(), listFish.get(i).getX()*DOT_SIZE, listFish.get(i).getY()*DOT_SIZE, this);
        }
       
        for (int i = 0; i < listDeco.size(); i++) {
            g.drawImage(listDeco.get(i).getDeco(), listDeco.get(i).getX()*DOT_SIZE, listDeco.get(i).getY()*DOT_SIZE, this);   
        }

        for (int i = 0; i < listBug.size(); i++) {
            g.drawImage(listBug.get(i).getBug(), listBug.get(i).getX()*DOT_SIZE, listBug.get(i).getY()*DOT_SIZE, this);   
        }

        for (int i = 0; i < listPast.size(); i++) {
            g.drawImage(listPast.get(i).getPast(), listPast.get(i).getX()*DOT_SIZE, listPast.get(i).getY()*DOT_SIZE, this);   
        }  
        
        for (int i = 0; i < listRosa.size(); i++) {
            g.drawImage(listRosa.get(i).getRosa(), listRosa.get(i).getX()*DOT_SIZE, listRosa.get(i).getY()*DOT_SIZE, this);   
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

            if ((key == KeyEvent.VK_0) ) { //TODOO fonctionne pas bien, le poisson bleu ne sais plus ou aller, il, pert sa target 
                listFish.removeAll(listFish);
                listBug.removeAll(listBug);
                listDeco.removeAll(listDeco);
                listPast.removeAll(listPast);
                doUpdate();
                numberOfDeco=0;
                setBackground(Color.black);
                temperature="tiede";
                initGame();       
              
            }

            if ((key == KeyEvent.VK_1) ) {
                setBackground(Color.yellow);
                temperature="cold";
            }

            if ((key == KeyEvent.VK_2) ) {
                setBackground(Color.black);
                temperature="tiede";
            }

            if ((key == KeyEvent.VK_3) ) {
                setBackground(Color.green);
                temperature="hard";
            }

            if ((key == KeyEvent.VK_4) ) {
                addBug();
            }

            if ((key == KeyEvent.VK_5) ) { // TODO quand je rajoute des pastille il s'arrette pas
                addPast();
            }

            if ((key == KeyEvent.VK_6) ) { // fonctionne pas 
              
                
            }

            if ((key == KeyEvent.VK_7) ) { // fonctionne pas 
              
            }

            if ((key == KeyEvent.VK_8) ) { // fonctionne pas 
              
            }

            if ((key == KeyEvent.VK_9) ) { 
                int x = (int)(1 + (Math.random() * (4)));
                switch (x) {
                    case 1:
                    listFish.add(new FishBlue("orange", "Images/FishRed.png",0, 10));
                        break;
                    case 2:
                    listFish.add(new FishRed("red", "Images/FishRed.png",0, 10));
                        break;
                    case 3:
                    listFish.add(new FishOrange("red", "Images/FishRed.png",0, 10));
                        break;
                    case 4:
                    listFish.add(new FishPurple("red", "Images/FishRed.png",0, 10));
                        break;  

                    default:
                        break;
                }        
            }
            if ((key == KeyEvent.VK_R) ) { 
                for (int j = 0; j < Aquarium.listFish.size(); j++) {
                    if(Aquarium.listFish.get(j).getId()!=4){
                    Aquarium.listFish.get(j).tqt = false;
                    }
                  }   
            }
            if ((key == KeyEvent.VK_B) ) {
                for (int j = 0; j < Aquarium.listFish.size(); j++) {
                    if(Aquarium.listFish.get(j).getId()!=2){
                    Aquarium.listFish.get(j).tqt = false;
                    }
                  }
            }

            if ((key == KeyEvent.VK_M) ) {
                for (int j = 0; j < Aquarium.listFish.size(); j++) {
                    if(Aquarium.listFish.get(j).getId()!=3){
                    Aquarium.listFish.get(j).tqt = false;
                    }
                  }
            }

            if ((key == KeyEvent.VK_O) ) {
                for (int j = 0; j < Aquarium.listFish.size(); j++) {
                    if(Aquarium.listFish.get(j).getId()!=1){
                    Aquarium.listFish.get(j).tqt = false;
                    }
                  }
            }
        }
            
    }
}
