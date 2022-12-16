import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

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
            
            listFish.add(new FishRed("red",100, "Images/FishRed.png",0,30));
            listFish.add(new FishBlue("orange",100, "Images/FishRed.png",0, 30));
            listFish.add(new FishOrange("orange",100, "Images/FishRed.png",0,30));
            listFish.add(new FishPurple("red",100, "Images/FishRed.png",0,30));
        
    }

    private void addDeco(){
        for (int i = 0; i < 0; i++) {
            listDeco.add(new Decoration("Images/rec.png"));
            
            numberOfDeco++;
        }
    }

    private void addBug(){
        for (int i = 0; i < 20; i++) {
            listBug.add(new Bug("Image/pap.png","Butterfly")); 
            listBug.add(new Bug("Image/cockroach.png","Cockroach"));
                
            
        }
    }

    private void addPast(){
        for (int i = 0; i < 0; i++) {
            listPast.add(new Past("Image/past.png"));
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
        getlistFishPrey(); // regarder si ses getteurs sont indipsenable ici 
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();  
    }

    public static void removeFromListFish(Fish fish) {
        listFish.remove(fish);
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
            
}
