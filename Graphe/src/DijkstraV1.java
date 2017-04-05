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
		tab=new double[g.hmap.size()][3];

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
					{
						tab[i][1]=a.getPoids();
						break;
					}
						
						
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
			tab[i][2]=source.getIdnoeud();
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
			System.out.println(tab[i][0]+" : "+tab[i][1]+" Parent : "+tab[i][2]);
	}
	
	public boolean verif(double test)
	{
		for(int i=0;i<non_marque.size();i++)
			if(non_marque.get(i).getIdnoeud()==test)
				return true;
		return false;
	}
	
	public int mini(){
		int lolxD=0;
		double tempo=Double.POSITIVE_INFINITY;
		for(int i=0;i<tab.length;i++)
		{
			if(this.verif(tab[i][0]))
			{
				if(tempo>=tab[i][1])
				{
					tempo=tab[i][1];
					lolxD=i;
				}
			}
		}
		
		return lolxD;
		
		
		
	}
	
	
	public void remove(double test)
	{
		int lol=(int)test;
		for(int i=0;i<non_marque.size();i++)
			if(non_marque.get(i).getIdnoeud()==lol)
				non_marque.remove(i);
	}
	
	public int get(int lol){
		for(int i=0;i<non_marque.size();i++)
			if(non_marque.get(i).getIdnoeud()==lol)
				return i;
		return lol;
	}
	
	public int indice (int id)
	{
		for(int i=0;i<tab.length;i++)
		{
			if(id==tab[i][0])
				return i;
		}
		return 0;
	}
	
	public void algorithme()
	{
		System.out.println("Initialisation...");
		this.init();
		this.affiche();
		int choix=0;
		int indice;
		int indice2;
		LinkedList<Arc> tempo=null;
		System.out.println("Fin initialisation...");
		while(!non_marque.isEmpty()) //Tant qu'il y a des sommets non marqués on continue
		{	
			choix=this.mini();
			if(tab[choix][1]==Double.POSITIVE_INFINITY)
				break;
			tempo=non_marque.get(this.get((int)tab[choix][0])).getSuccesseurs();
			this.remove(tab[choix][0]);
			for(int i=0;i<tempo.size();i++)
			{
				indice=this.indice(tempo.get(i).getX());
				indice2=this.indice(tempo.get(i).getY());
				if(this.verif(tempo.get(i).getY())){
					if((tab[indice][1]+tempo.get(i).getPoids())<tab[indice2][1])
							{
								tab[indice2][1]=tab[indice][1]+tempo.get(i).getPoids();
								tab[indice2][2]=tempo.get(i).getX();
								
							}
				}
				this.afficheTab();
				System.out.println();
				
			} 
			
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