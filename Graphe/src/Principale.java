import java.util.HashMap;

public class Principale {

	public static void main(String[] args)
	{
		HashMap<Integer, Noeud> hmap = new HashMap<Integer, Noeud>();
		Graphe g = new Graphe(hmap);
		g.CSV();
		System.out.println("Inialisation...");
		DijkstraV1 test=new DijkstraV1(g,g.hmap.get(1));
		test.init();
		test.affiche();
		System.out.println("Fin inialisation.");
	}

}