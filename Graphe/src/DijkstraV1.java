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
	//pluscourtChemin();//en fait je suppose que le prof voulait écrire méthode à la place de classe mais je suis pas sur//fonction pas finie
	}
	public void pluscourtChemin(Graphe G){
	int compteur = 0;
	for(int i = 0; i<G.nbSommet();i++){
		nonmarqués.get(i).marque=false;
		source[i]=0;//. si on suppose que les sommets ont forcément un index >=1
		parents[i]=0;//idem
	}
	source[compteur]=depart;
	actuel[depart]=-1;//-1 si on suppose qu'on a nommé le premier noeud 0
	parents[depart]=depart;
	for(int i=0;i<G.nbSommet();i++){
		
	}
	//calculedistmin();//fonction pas finie

}
	public void calculedistmin(Graphe G){
		for(int i = 0;i<G.nbSommet();i++){
			// si il existe un arc entre le premier noeud de G et noeud d'indice i
			//alors plus court chemin "actuel" = distance entre noeud 0 et noeud 1
			//parents de noeud de I devrait etre du coup le noeud 0
		}
	}
	
}