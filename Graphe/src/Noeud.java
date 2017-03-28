import java.util.LinkedList;

public class Noeud {

	public int idnoeud;
	public LinkedList<Arc> successeurs=new LinkedList<Arc>();
	boolean marque ;

	public Noeud (int x){
		idnoeud=x;
		marque = false;
	}

	public void ajoutSuccesseurs(Noeud a,float p){
		if(successeurs.isEmpty()||!successeurs.contains(new Arc(this,a,p)))
			this.successeurs.add(new Arc(this,a,p));
	}
	public void ajouteArc(Arc x){
		boolean present = false;
		for(int i=0;i<this.successeurs.size();i++){
			if(this.successeurs.get(i).getY()==x.getY())
				present = true;
		}
		if (!present)
		this.successeurs.add(x);
	}

	public void affiche(){
		System.out.println(this.idnoeud +" : ");
		for (int i=0; i< this.successeurs.size(); i++){
			System.out.println("MODR PHFZOIHFZOFHBZI : "+this.successeurs.size());
			System.out.print(successeurs.get(i).getY() +", " );


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
