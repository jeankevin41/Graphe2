import java.util.ArrayList;

public class DijkstraV1 {
	public ArrayList<Noeud>nonmarqués=new ArrayList<Noeud>();
	public int depart;
	public int [] source;
	public int [] parents;
	public int [] actuel;
	public Graphe g;
	public DijkstraV1(int k, Graphe G){
	depart = k; 
	g=G;
	int dimtotale = G.nbSommet();
	source=new int [dimtotale];
	parents= new int [dimtotale];
	actuel = new int [dimtotale];
	pluscourtChemin();//en fait je suppose que le prof voulait écrire méthode à la place de classe
	}
	public void pluscourtChemin(Graphe G){
	int compteur = 0;
	for(int i = 0; i<G.nbSommet();i++){
		nonmarqués.get(i).marque=false;
	}
	calculedistmin();

}
	public void calcule
}