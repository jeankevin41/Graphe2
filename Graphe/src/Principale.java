import java.util.HashMap;

public class Principale {

	public static void main(String[] args)
	{
		HashMap<Integer, Noeud> hmap = new HashMap<Integer, Noeud>();
		/*Graphe g = new Graphe(hmap);
		g.CSV();
		DijkstraV1 test=new DijkstraV1(g,g.hmap.get(1));
		test.algorithme();*/
		
		Graphe g=new Graphe();
		g.remplirGraphe(500, 750);
		g.affiche();
		DijkstraV1 test=new DijkstraV1(g,g.hmap.get(5));
		test.algorithme();
	}
	

}