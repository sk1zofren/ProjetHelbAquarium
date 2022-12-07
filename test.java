public class test{

    private static String[] COULEURS_POSSIBLES = {"rose", "blanc", "rouge"};

    public static void main(String[] args) {
        
     if(coulPoss("blac")){

        System.out.println("c'est bon");
     }else{
        System.out.println("c'est pas bon");
     }
       
    }

    public static boolean coulPoss(String couleur){

        for(String coul: COULEURS_POSSIBLES) {
            if(coul.equals(couleur)) {
                return true;
            }
        }
        return false;
        
    }



}