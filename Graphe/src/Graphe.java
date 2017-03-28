import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Graphe {

     HashMap<Integer, Noeud> hmap = new HashMap<Integer, Noeud>();

     public Graphe(){}

     public Graphe(HashMap<Integer,Noeud> b){
         this.hmap=b;
     }

     public void ajouteNoeud(Noeud k){
         if(hmap.get(k.idnoeud)==null)
            this.hmap.put(k.idnoeud,k);
     }

     public void ajoutArc(Noeud a,Noeud b,float p){
    	Arc z = new Arc(a,b,p);
    	 if(hmap.get(z.getX())==null)
    		 this.hmap.put(z.getX(),a);
    	 if(hmap.get(z.getY())==null)
        	this.hmap.put(z.getY(),b);
    	  a.ajouteArc(z);
     	}

     public void CSV(){
    	 BufferedReader Buffer = null;
    	 try {
 			String line;
 			Buffer = new BufferedReader(new FileReader("graph1.csv"));

 			while ((line = Buffer.readLine()) != null) {
 				System.out.println("Raw CSV data: " + line);

 				//System.out.println("Converted ArrayList data: " + crunchifyCSVtotab(Line) + "\n");
 				@SuppressWarnings("rawtypes")
				ArrayList tempo=crunchifyCSVtotab(line);
 				Noeud a=new Noeud((int)tempo.get(0));
 				this.ajouteNoeud(a);
 				Noeud b=new Noeud((int)tempo.get(1));
 				this.ajouteNoeud(b);
 				Arc a2 = new Arc(a,b,(float)tempo.get(2));
 				a.ajouteArc(a2);
 				//a.ajoutSuccesseurs(b,(float)tempo.get(2));
 				//this.ajoutArc(a,b,(float)tempo.get(2));
 			}

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
 	public void affiche(){
 		this.hmap.get(1).affiche();
 	}
 	public int nbSommet(){
 		return this.hmap.size();
 	}

}