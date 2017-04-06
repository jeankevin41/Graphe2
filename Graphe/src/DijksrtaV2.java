import java.util.LinkedList;
import java.util.Map.Entry;

public class DijksrtaV2 {
	Noeud source;
	BinaryHeap binary;
	double [][] tab;
	Graphe g;
	
	public DijksrtaV2(Graphe g, Noeud source)
	{
		this.source=source;
		this.binary=new BinaryHeap(g.hmap.size());
		this.tab=new double[g.hmap.size()][3];
		this.g=g;
	}
	
	public void init()
	{
		double id=0;
		double poids=0;
		Arc a=null;
		LinkedList<Arc> success=source.getSuccesseurs();
		for(Entry<Integer, Noeud> entry : g.hmap.entrySet())
		{
			
			poids=0.0;
			if(!entry.getValue().equals(source))
			{
				for(int j =0;j<success.size();j++)
				{
					id=entry.getValue().getIdnoeud();
					a=success.get(j);
					if(a.getY()==entry.getValue().getIdnoeud())
					{
						poids=a.getPoids();
						break;
					}
						
						
				}
				
			if(poids==0.0)
				poids=Double.POSITIVE_INFINITY;
			binary.insert(id, poids);
			}
			else
			{
				tab[0][0]=entry.getValue().getIdnoeud();
				tab[0][1]=0;
				tab[0][2]=entry.getValue().getIdnoeud();
			}
			
		}
	
	}
	
	public Noeud trouve(double id){
		Noeud tempo=null;
		for(Entry<Integer, Noeud> entry : g.hmap.entrySet()) {

 		    if(entry.getValue().getIdnoeud()==id)
 		    	return entry.getValue();
 		}
		return tempo;
	}
	
	public void algorithme()
	{
		init();
		Double choix[];
		LinkedList<Arc> tempo=null;
		while(!binary.isEmpty()) //Tant qu'il y a des sommets non marqués on continue
		{	
			choix=binary.removeMin();
			System.out.println(choix[0]);
			if(choix[1]==Double.POSITIVE_INFINITY)
				break;
			tempo=this.trouve(choix[0]).getSuccesseurs();
			for(int i=0;i<tempo.size();i++)
			{
				if(binary.verif(tempo.get(i).getY())){
					
					if((choix[1]+tempo.get(i).getPoids()<binary.getPoids(tempo.get(i).getY())))
							{
								binary.update(tempo.get(i).getY(), choix[1]+tempo.get(i).getPoids());
								//tab[indice2][2]=tempo.get(i).getX();
								
							}
				}
				
			}
			System.out.println();
			
		}
		
		
	}

		
	}
	
	

