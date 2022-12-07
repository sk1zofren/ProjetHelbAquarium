import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;

public abstract class Fish  {
    
    protected String colors; // TODO devra etre supprimer car pas utiliser
    private final Image fishImage;
    private int id=0; // TODO devra etre supprimer car pas utiliser
    protected  int move; // TODO devra etre supprimer car pas utiliser
    protected int vitesse=1; // TODO devra etre supprimer car pas utiliser
    protected int vitesseMax=3; // TODO devra etre supprimer car pas utiliser
    protected int pos_x; // coordoneé X du poisson
    protected int pos_y; // coordoneé Y du poisson
    protected int target_x ; // coordoneé X de la cible du poisson
    protected int target_y ; // coordoneé Y de la cible du poisson
    protected int newTarget_X;// nouvelle coordoneé X de la cible du poisson
    protected int newTarget_Y;// nouvelle coordoneé Y de la cible du poisson
    protected boolean touchOb=false;

    public Fish(String colors , int speedMax, String nameImage,int id) {

        ImageIcon iib = new ImageIcon(nameImage);
        fishImage = iib.getImage();
        this.colors = colors;  
        this.id=id;
        pos_x = (int) (1 + (Math.random() * (Aquarium.getTaille()))); // -1 c'est pour eviter que le poisson appraisse directemet dans les bords
        pos_y =  (int) (1 + (Math.random() * (Aquarium.getTaille())));
        
    }

    public Image getFish(){    
        return fishImage;
    }

    // TODO devra etre supprimer car pas utiliser
    public  String getColors(){
        return colors;
    }

    public  int getX(){
        return pos_x;
    }

    public int getY(){
        return pos_y;
    }

    // TODO les deux méthodes setx et setY ne me seront pas utile donc je devrais bientot les supprimer  
    public void setX(int newX){
    pos_x=newX;
    }

    public void setY(int newY){
        pos_y=newY;
    }    

    // TODO devra etre supprimer car pas utiliser
    public int getId(){
    return id;
    }

    private void move() {

        ArrayList<Integer> x_moveOptions = new ArrayList<Integer>() ;
        ArrayList<Integer> y_moveOptions = new ArrayList<Integer>() ;
        ArrayList<Double> distances = new ArrayList<Double>() ;

        for (int i = -1 ; i <= 1 ; i++){
            for (int j = -1 ; j <= 1 ; j++){
                int test_pos_x = pos_x +i* Aquarium.getPas();
                int test_pos_y = pos_y +j* Aquarium.getPas();
                if (isValidPosition(test_pos_x, test_pos_y)){
                    x_moveOptions.add(test_pos_x);
                    y_moveOptions.add(test_pos_y);
                }
            }
        }

        for (int i=0; i < x_moveOptions.size() ; i++){
            Double distance = getDistance(target_x, target_y, x_moveOptions.get(i), y_moveOptions.get(i));
            distances.add(distance);
        } 

        double min = Collections.min(distances);
        int min_index = distances.indexOf(min);

        pos_x = x_moveOptions.get(min_index);
        pos_y = y_moveOptions.get(min_index);
        }

        private boolean isValidPosition(int pos_x, int pos_y) { // savoir si il sera dans le board et donc ici je met la position des o
        // objets qu'il ne doit pas toucher comme les obstacles

        boolean res = true ;
        if (pos_y >= Aquarium.getHeights()) {
        res = false;
        }

        if (pos_y < 0) {
        res = false;
        }
        
        // TODO demander au prof si ce code est de la duplication de code
        for (int j = 0; j < Aquarium.listDeco.size(); j++) {

        if (  pos_y >= Aquarium.listDeco.get(j).getY()-10 && pos_y <= Aquarium.listDeco.get(j).getY()+10 && pos_x == Aquarium.listDeco.get(j).getX()+10) {
            res = false;
            touchOb = true;
        }

        if (  pos_y >= Aquarium.listDeco.get(j).getY()-10 && pos_y <= Aquarium.listDeco.get(j).getY()+10 && pos_x == Aquarium.listDeco.get(j).getX()-10) {
            res = false;
            touchOb =true;
        }

        if (  pos_x >= Aquarium.listDeco.get(j).getX()-10 && pos_x <= Aquarium.listDeco.get(j).getX()+10 && pos_y == Aquarium.listDeco.get(j).getY()+10) {
            res = false;
            touchOb =true;
        }

        if (  pos_x >= Aquarium.listDeco.get(j).getX()-10 && pos_x <= Aquarium.listDeco.get(j).getX()+10 && pos_y == Aquarium.listDeco.get(j).getY()-10) {
            res = false;
            touchOb =true;
        }

        }

        if (pos_x >= Aquarium.getLenghts()) {
        res = false;
        }

        if (pos_x < 0) {
        res = false;
        }
        return res;
        }

        private double getDistance(int pos_x0, int pos_y0, int pos_x1, int pos_y1){
        int x_dist = pos_x1-pos_x0;
        int y_dist = pos_y1-pos_y0;
        return Math.sqrt(Math.pow(x_dist, 2)+Math.pow(y_dist, 2));
        }




    public void update(){

        for (int i = 0; i < Aquarium.listFish.size(); i++) {  
            Aquarium.listFish.get(i).move();
        }

    }



}
