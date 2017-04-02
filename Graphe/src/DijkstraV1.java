import java.util.ArrayList;
import java.util.LinkedList;
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
		ArrayList<Noeud> non=new ArrayList<Noeud>(); 
		int i=0;
		Arc a=null;
		LinkedList<Arc> success=source.getSuccesseurs();
		for(Entry<Integer, Noeud> entry : g.hmap.entrySet())
		{
			
			if(!entry.getValue().equals(source))
			{
				for(int j =0;j<success.size();j++)
				{
					tab[i][0]=entry.getValue().getIdnoeud();
					a=success.get(j);
					if(a.getY()==entry.getValue().getIdnoeud())
						tab[i][1]=a.getPoids();
						
				}
				non.add(entry.getValue());
				
				if(tab[i][1]==0.0)
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
		Noeud b = new Noeud();
		Noeud d;
		Noeud c = new Noeud();
		System.out.println("Initialisation...");
		this.init();
		this.affiche();
		System.out.println("Fin initialisation...");
		int choix=0;
		double mini = tab[0][1];
		ArrayList<ArrayList<Integer>>  gamma = new ArrayList<ArrayList<Integer>>();
		while(!non_marque.isEmpty()) //Tant qu'il y a des sommets non marqués on continue
		{
			 float poids1=0;
			 float poids2=0;
			for (int i = 1;i<tab[0].length;i++){
				if(tab[0][i]<mini){
					mini=tab[0][i];
			}}	
				if(mini==Double.POSITIVE_INFINITY)
				break;
				
			for(int i = 0;i<g.hmap.size();i++){
				b = g.hmap.get(i);
				for (int j = 0;j<b.successeurs.size();j++){
					Arc a = b.successeurs.get(j);
					if(a.getX()==source.getIdnoeud()&&a.getPoids()==mini){
						b=g.hmap.get(a.getX());
						d=g.hmap.get(a.getY());
						j=b.successeurs.size()+1;
						i=g.hmap.size()+1;
					}
						
				}
			}
			ArrayList<Noeud>stock=new ArrayList<Noeud>();
	
			 for (int a5 = 0 ;a5<b.successeurs.size();a5++){//récupère l'id de tout les noeuds en relation directe avec b
				c=g.hmap.get(b.successeurs.get(a5).getY());
				stock.add(c);
			 }
			 for (int a7 = 0;a7<b.successeurs.size();a7++){//on va regarder si c et source  ont des arcs qui vont vers les mêmes noeuds
				 int c2 = b.successeurs.get(a7).getY();
				 for (int a8 = 0;a8<b.successeurs.size();a8++){
					 if (b.successeurs.get(a8).getY()==c2){//si ils ont des arcs en commun alors on va récuperer leur poids
						 for (int a9 = 0;a9<b.successeurs.size();a9++){
							 if (c.successeurs.get(a9).getY()==c2)
								 poids1 = c.successeurs.get(a9).getPoids();
						 }
						 for (int a9 = 0;a9<b.successeurs.size();a9++){
							 if (b.successeurs.get(a9).getY()==c2)
								 poids2 = b.successeurs.get(a9).getPoids();

						 }
					 }
					 if(poids1<poids2){//si le poids est meilleur de c a un autre noeud
							 tab[c.getIdnoeud()][c2]=poids1;
							 gamma.get(c2).add(b.getIdnoeud());}//on ajoute l'id du noeud parent c dans la liste des parents du noeud dont l'id est c2

				     if(poids1>poids2){//si le poids est meilleur de c a un autre noeud
								 tab[c.getIdnoeud()][c2]=poids2;
								 gamma.get(c2).add(b.getIdnoeud());//on ajoute l'id du noeud parent b dans la liste des parents du noeud dont l'id est c2

				 }
	

		
				 }}
			non_marque.remove(choix); //si un sommet est marqué on le supprime de l'arrayList
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