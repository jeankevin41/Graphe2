
public class Arc {

	public int x;
	public int y;
	public float poids;

	public Arc (Noeud a, Noeud b, float p){
		this.x=a.getIdnoeud();
		this.y=b.getIdnoeud();
		poids=p;

	}

	public void affiche(){

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}



}
