import java.util.ArrayList;
import java.util.LinkedList;
public class dijkstra1 {
	public Graphe G;
public Noeud Source;
public ArrayList<Noeud>liste = new ArrayList<Noeud>();

	public dijkstra1(Graphe g2, Noeud source2){
		ArrayList<Noeud>liste2 = new ArrayList<Noeud>();
		for(int i = 0;i<g2.nbSommet();i++){
			liste2.set(i, g2.hmap.get(i));
		}
		this.liste=liste2;
		double stock[] = new double [liste.size()];
		double stock2[] = new double [liste.size()];
		int a = source2.idnoeud;
		for(int j = 0;j<stock.length;j++){
			if (j==a)
				stock[j]=0;
			else 
				stock[j]=Double.POSITIVE_INFINITY ;				
		}
		boolean k = false;
		int choix = 0;
		while(k==false){
			Noeud b;
			for(int i = 0;i<stock.length;i++){
				if (stock[i]==Double.POSITIVE_INFINITY)
					choix=1;
			}
			 b = g2.hmap.get(choix);
			 ArrayList<Float> help2 = new ArrayList<Float>();
			 ArrayList<Integer> help = new ArrayList<Integer>();
			 for(int w = 0;w<b.successeurs.size();w++){				 
				 help.set(w,b.successeurs.get(w).getY());
				 help2.set(w,b.successeurs.get(w).getPoids());
			 }
			 //Calculer la somme s du poids de notre sommet source2 X et du poids de l'arc reliant X � Y.
			 //Si la somme s est inf�rieure au poids provisoirement affect� au sommet Y, affecter provisoirement � Y le nouveau poids s et indiquer entre parenth�ses le sommet X pour se souvenir de sa provenance.
			// QUAND LE SOMMET S EST D�FINTIVEMENT MARQU�
			 //Le plus court chemin de E � S s'obtient en �crivant de gauche � droite le parcours en partant de la fin S.
			 
		}
			
			
	}
}
