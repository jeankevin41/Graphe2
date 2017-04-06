import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Graphe {

     HashMap<Integer, Noeud> hmap = new HashMap<Integer, Noeud>();

     public Graphe(){}

     public Graphe(HashMap<Integer,Noeud> b){
         this.hmap=b;
     }
     
     public void remplirGraphe(int n, int p)
     {
    	 ArrayList<Noeud> a=new ArrayList<Noeud>();
    	 while (n!=0)
    	 {
    		 a.add(new Noeud(n));
    		 n--;
    	 }
    	 int idNoeud1=0; int poids=0; int idNoeud2=(int)(Math.random()*((a.size())));;
    	 while(p!=0)
    	 {
    		
    		 poids=(int)(Math.random()*(11));
    		 if(idNoeud1==idNoeud2 && !(a.get(idNoeud1).aSuccesseurs(a.get(idNoeud2))))
    			idNoeud2=(int)(Math.random()*((a.size())));
    		 else
    		 {
    			 a.get(idNoeud1).ajoutSuccesseurs(a.get(idNoeud2), poids);
    			 p--;
    		 }
    		 if(idNoeud1==a.size()-1)
    			 idNoeud1=0;
    		 else 
    			idNoeud1++;
    		idNoeud2=(int)(Math.random()*((a.size())));
    	 }
    	 
    	 for(int i=0;i<a.size();i++){
    		 this.ajouteNoeud(a.get(i));
    	 }
     }
  	

     public void ajouteNoeud(Noeud k)
     {
         if(!hmap.containsKey(k.idnoeud))
            this.hmap.put(k.idnoeud,k);
     }


     public void CSV(){
    	 BufferedReader Buffer = null;
    	 try {
 			String line;
 			Buffer = new BufferedReader(new FileReader("graph1.csv"));
 			Noeud a = null;

 			while ((line = Buffer.readLine()) != null) {
				@SuppressWarnings("rawtypes")
				ArrayList tempo=crunchifyCSVtotab(line);
				if(a==null)
					a=new Noeud((int)tempo.get(0));
				else
					if(a.idnoeud!=(int)tempo.get(0))
					{
						this.ajouteNoeud(a);
						a=new Noeud((int)tempo.get(0));
					}
 				Noeud b=new Noeud((int)tempo.get(1));
 				a.ajoutSuccesseurs(b,(float)tempo.get(2));

 			}
 			this.ajouteNoeud(a);

 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			try {
 				if (Buffer != null) Buffer.close();
 			} catch (IOException crunchifyException) {
 				crunchifyException.printStackTrace();
 			}
     }

     }
 	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList crunchifyCSVtotab(String CSV) {
		ArrayList h=new ArrayList();
		if (CSV != null) {
			String[] splitData = CSV.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++)
				if (!(splitData[i] == null) || !(splitData[i].length() == 0))
					if(i<2)
						h.add(Integer.parseInt(splitData[i].trim()));
					else
						h.add(Float.parseFloat(splitData[i].trim()));
			}
		return h;
	}
 	public void affiche()
 	{
 		for(Entry<Integer, Noeud> entry : hmap.entrySet()) {

 		    Noeud valeur = entry.getValue();
 		    valeur.affiche();
 		}
 	}
 	public int nbSommet(){
 		return this.hmap.size();
 	}
 	

}