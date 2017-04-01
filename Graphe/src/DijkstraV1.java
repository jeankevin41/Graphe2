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
		System.out.println("Initialisation...");
		this.init();
		this.affiche();
		System.out.println("Fin initialisation...");
		ArrayList<ArrayList<Integer>>  gamma = new ArrayList<ArrayList<Integer>>();
		ArrayList<Float> poids = new ArrayList<Float>(); ;
		ArrayList<Float> help2 = new ArrayList<Float>();//liste pour stocker toute les autres (arcs) noeuds pas encore fixés et leur poids dans help2
		ArrayList<Integer> help = new ArrayList<Integer>();//
		ArrayList<Integer> alpha = new ArrayList<Integer>();
		ArrayList<Noeud>beta = new ArrayList<Noeud>();//récupère tout les noeuds grâce aux iD
		while(!non_marque.isEmpty()) //Tant qu'il y a des sommets non marqués on continue
		{

			 float poids1=0;
			 float poids2=0;
			 Noeud b;
				int a = source.idnoeud;
			

				for(int j = 0;j<source.successeurs.size();j++){
					int source2 = source.successeurs.get(j).getX();
					if (source2==a)
						poids.set(j, source.successeurs.get(j).getPoids());
				}
			float mini = poids.get(0);
				for (int z = 0; z<poids.size();z++){
					if (poids.get(z)<mini)
						mini = poids.get(z);
				}
				int choix = 0;
				for(int i = 0;i<poids.size();i++){// on selectionne le noeud qui vers le quel le poids est le plus petit
					if (poids.get(i)==mini)
						choix=i;
				}
				 b = g.hmap.get(choix);//b devient le noeud choisi au dessus
			
				 for(int w = 0;w<b.successeurs.size();w++){
					 help.set(w,b.successeurs.get(w).getY());
					 help2.set(w,b.successeurs.get(w).getPoids());
				 }
				

				 for (int a5 = 0 ;a5<b.successeurs.size();a++){//récupère l'id de tout les noeuds en relation directe avec b
					 alpha.set(a5, b.successeurs.get(a5).getY());
				 }
				
				 for (int a6 =0;a6<g.hmap.size();a6++){
					 beta.set(a6,g.hmap.get(a6));
				 }
				 for (int a7 = 0;a7<b.successeurs.size();a7++){//on va regarder si b et source 2 ont des arcs qui vont vers les mêmes noeuds
					 int c = b.successeurs.get(a7).getY();
					 for (int a8 = 0;a8<source.successeurs.size();a8++){
						 if (source.successeurs.get(a8).getY()==c){//si ils ont des arcs en commun alors on va récuperer leur poids
							 for (int a9 = 0;a9<b.successeurs.size();a9++){
								 if (b.successeurs.get(a9).getY()==c)
									 poids1 = b.successeurs.get(a9).getPoids();
							 }
							 for (int a9 = 0;a9<source.successeurs.size();a9++){
								 if (source.successeurs.get(a9).getY()==c)
									 poids2 = b.successeurs.get(a9).getPoids();

							 }
						 }
						 if(poids1<poids2){//si le poids est meilleur de b a un autre noeud
							 poids.set(c, poids1);
							 gamma.get(c).add(b.getIdnoeud());}//on ajoute l'id du noeud parent b dans la liste des parents du noeud dont l'id est c

				     if(poids1>poids2){//si le poids est meilleur de b a un autre noeud
				    	 poids.set(c, poids2);
								 gamma.get(c).add(source.getIdnoeud());//on ajoute l'id du noeud parent source2 dans la liste des parents du noeud dont l'id est c

				 }
			 }
		}
			//Algorithme
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