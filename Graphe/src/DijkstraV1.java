import java.util.ArrayList;
import java.util.Map.Entry;

public class DijkstraV1 {
	ArrayList<Noeud> non_marque=new ArrayList<Noeud>();
	Noeud source;
	Graphe g;

	public DijkstraV1(Graphe g, Noeud source)
	{
		this.source=source;
		this.g=g;
		non_marque=remplirNonMarque(g,source);
	}

	public static ArrayList<Noeud> remplirNonMarque(Graphe g,Noeud source)
	{
		ArrayList<Noeud> non=new ArrayList<Noeud>();
		for(Entry<Integer, Noeud> entry : g.hmap.entrySet())
			if(!entry.getValue().equals(source))
				non.add(entry.getValue());

		return non;
	}

	public void affiche(){
		System.out.println("Source :");
		source.affiche();
		System.out.println("Graphe : ");
		g.affiche();
		System.out.print("Sommet non marqué : ");
		for(int i=0;i<non_marque.size();i++)
		{
			System.out.print(non_marque.get(i).getIdnoeud());
			if(i==non_marque.size()-1)
				System.out.println(".");
			else
				System.out.print(",");

		}
	}
























	public ArrayList<Noeud> getNon_marque() {
		return non_marque;
	}

	public void setNon_marque(ArrayList<Noeud> non_marque) {
		this.non_marque = non_marque;
	}

	public Noeud getSource() {
		return source;
	}

	public void setSource(Noeud source) {
		this.source = source;
	}

	public Graphe getG() {
		return g;
	}

	public void setG(Graphe g) {
		this.g = g;
	}

}