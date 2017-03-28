import java.util.HashMap;

public class PlusCourtChemin {
	   Noeud tab[]= new Noeud [1];
	   Boolean tab2[]= new Boolean [1];
	   Float tab3[]= new Float [1];
	   
	   public PlusCourtChemin(Noeud b){
		   tab2[0]=b.marque;
		   tab=b.predecesseur();
		   
	   }
  
}
}