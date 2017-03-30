import java.util.ArrayList;
import java.util.LinkedList;
public class dijkstra1 {
	public Graphe G;
public Noeud Source;
public ArrayList<Noeud>liste = new ArrayList<Noeud>();

	public dijkstra1(Graphe g2, Noeud source2){
		ArrayList<Noeud>liste2 = new ArrayList<Noeud>();//liste qui contiendra tous les noeuds

		for(int i = 0;i<g2.nbSommet();i++){//
			liste2.set(i, g2.hmap.get(i));//noeud dans la liste 2
		}
		this.liste=liste2; // remplacer liste par liste 2
		double poids[] = new double [liste.size()];//créér un tableau de taille = nombre de noeuds pour stocker les poids entre source et les autres noeuds
		ArrayList<ArrayList<Integer>>  gamma = new ArrayList<ArrayList<Integer>>();
		int a = source2.idnoeud;
		for(int j = 0;j<poids.length;j++){// boucle qui stocke les poids dans poids , si l'id du noeud testé = id noeud source , alors poids[i] = 0 , sinon infini
			if (j==a)
				poids[j]=0;
			else
				poids[j]=Double.POSITIVE_INFINITY ;
		}
		boolean k = false;
		int choix = 0;
		while(k==false){//tant qu'il reste une valeur à l'infini on boucle
			 float poids1=0;
			 float poids2=0;
			Noeud b;
			double mini = poids[0];
			for (int z = 0; z<poids.length;z++){
				if (poids[z]<mini)
					mini = poids[z];
			}
			for(int i = 0;i<poids.length;i++){// on selectionne le noeud qui vers le quel le poids est le plus petit
				if (poids[i]==mini)
					choix=i;
			}
			 b = g2.hmap.get(choix);//b devient le noeud choisi au dessus
			 ArrayList<Float> help2 = new ArrayList<Float>();//liste pour stocker toute les autres (arcs) noeuds pas encore fixés et leur poids dans help2
			 ArrayList<Integer> help = new ArrayList<Integer>();//
			 for(int w = 0;w<b.successeurs.size();w++){
				 help.set(w,b.successeurs.get(w).getY());
				 help2.set(w,b.successeurs.get(w).getPoids());
			 }
			 int alpha[] = new int[liste.size()];
			 for (int a5 = 0 ;a5<b.successeurs.size();a++){//récupère l'id de tout les noeuds en relation directe avec b
				 alpha[a5]=b.successeurs.get(a5).getY();
			 }
			 ArrayList<Noeud>beta = new ArrayList<Noeud>();//récupère tout les noeuds grâce aux iD
			 for (int a6 =0;a6<g2.hmap.size();a6++){
				 beta.set(a6,g2.hmap.get(a6));
			 }

			 for (int a7 = 0;a7<b.successeurs.size();a7++){//on va regarder si b et source 2 ont des arcs qui vont vers les mêmes noeuds
				 int c = b.successeurs.get(a7).getY();
				 for (int a8 = 0;a8<source2.successeurs.size();a8++){
					 if (source2.successeurs.get(a8).getY()==c){//si ils ont des arcs en commun alors on va récuperer leur poids
						 for (int a9 = 0;a9<b.successeurs.size();a9++){
							 if (b.successeurs.get(a9).getY()==c)
								 poids1 = b.successeurs.get(a9).getPoids();
						 }
						 for (int a9 = 0;a9<source2.successeurs.size();a9++){
							 if (source2.successeurs.get(a9).getY()==c)
								 poids2 = b.successeurs.get(a9).getPoids();

						 }
					 }
					 if(poids1<poids2){//si le poids est meilleur de b a un autre noeud
							 poids[c]=poids1;
							 gamma.get(c).add(b.getIdnoeud());}//on ajoute l'id du noeud parent b dans la liste des parents du noeud dont l'id est c

				     if(poids1>poids2){//si le poids est meilleur de b a un autre noeud
								 poids[c]=poids2;
								 gamma.get(c).add(source2.getIdnoeud());//on ajoute l'id du noeud parent source2 dans la liste des parents du noeud dont l'id est c

				 }
			 }
		}


	}
}
}
