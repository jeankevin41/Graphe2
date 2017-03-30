import java.util.ArrayList;
import java.util.Map.Entry;

public class DijkstraV1 {
	ArrayList<Noeud> non_marque=new ArrayList<Noeud>();
	double[][] tab;
	Noeud source;
	Graphe g;

	public DijkstraV1(Graphe g, Noeud source)
	{
		this.source=source;
		this.g=g;
		tab=new double[g.hmap.size()][2];

	}

	public void init()
	{
		ArrayList<Noeud> non=new ArrayList<Noeud>(); int i=0;
		for(Entry<Integer, Noeud> entry : g.hmap.entrySet())
		{

			if(!entry.getValue().equals(source))
			{
				non.add(entry.getValue());
				tab[i][0]=entry.getValue().getIdnoeud();
				tab[i][1]=Double.POSITIVE_INFINITY;
			}
			else
			{
				tab[i][0]=entry.getValue().getIdnoeud();
				tab[i][1]=0;
			}
			i++;
		}
		non_marque=non;
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

		System.out.println("Tableau : ");
		this.afficheTab();
	}
	
	
	public void afficheTab(){
		for(int i=0;i<tab.length;i++)
			System.out.println(tab[i][0]+" : "+tab[i][1]);
	}
	
	public void algorithme()
	{
		System.out.println("Initialisation...");
		this.init();
		this.affiche();
		System.out.println("Fin initialisation...");
		while(!non_marque.isEmpty()) //Tant qu'il y a des sommets non marqués on continue
		{
			//Algorithme
			non_marque.remove(0); //si un sommet est marqué on le supprime de l'arrayList
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