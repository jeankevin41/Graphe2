import java.util.HashMap;

public class Principale {

	public static void main(String[] args) {
		HashMap<Integer, Noeud> hmap = new HashMap<Integer, Noeud>();
		Graphe g = new Graphe(hmap);
		g.CSV();
		g.affiche();

	}

}