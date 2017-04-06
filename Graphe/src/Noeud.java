import java.util.LinkedList;

public class Noeud {

	public int idnoeud;
	public LinkedList<Arc> successeurs=new LinkedList<Arc>();

	public Noeud()
	{

	}

	public Noeud (int x)
	{
		idnoeud=x;
	}

	public void ajoutSuccesseurs(Noeud a,float p){
		if(successeurs.isEmpty()||!successeurs.contains(new Arc(this,a,p)))
			this.successeurs.add(new Arc(this,a,p));
	}
	
	public boolean aSuccesseurs(Noeud a){
		
		for(int i=0;i<successeurs.size();i++)
		{
			if(successeurs.get(i).getY()==a.getIdnoeud())
				return true;
		}
		return false;
	}
	
	public Double cout(Noeud b)
	{
		
		Arc a=null;
		for(int i=0;i<successeurs.size();i++)
		{
			a=successeurs.get(i);
			if(a.getY()==b.getIdnoeud())
				return (double) a.getPoids();
		}
		
		return Double.POSITIVE_INFINITY;
	}


	public void affiche(){
		System.out.print(this.idnoeud+" : ");
		for (int i=0; i< this.successeurs.size(); i++){
			System.out.print(successeurs.get(i).getY());
			if(i<this.successeurs.size()-1)
				System.out.print(", ");
			else
				System.out.println(".");


		}
	}
	public Noeud predecesseur(Graphe G) {//à faire , il faut récupérer le nom du noeud précedent notre noeud
		int z = this.getIdnoeud();
		for (int i =0;i<G.hmap.size();i++){
			Noeud k = G.hmap.get(i);
			for(int j = 0;j<k.successeurs.size();i++){
				int xxx = k.successeurs.get(j).getY();
				if (xxx==z){
					return k;
				}
			}
		}
		return this;
	}
	public int getIdnoeud() {
		return idnoeud;
	}

	public void setIdnoeud(int idnoeud) {
		this.idnoeud = idnoeud;
	}

	public LinkedList<Arc> getSuccesseurs() {
		return successeurs;
	}

	public void setSuccesseurs(LinkedList<Arc> successeurs) {
		this.successeurs = successeurs;
	}


}
