
public class BinaryHeap {
		/*Nombre, taille
		 http://stackoverflow.com/questions/18241192/implement-heap-using-a-binary-tree */
	 	private static final int d = 2;
	    private int heapSize;
	    private int last;
	    private Double[][] heap;
	
	    
	    public boolean isEmpty()
	    {
	    	return heapSize==0;
	    }
	    
	    public boolean isFull()
	    {
	    	return heapSize==heap.length;
	    }
	    
	    public int parent(int i)
	    {
	    	return (i-1)/d;
	    }
	    
	    public int droit(int pere)
	    {
	    	return 2*pere+2;
	    }
	    
	    public int gauche(int pere)
	    {
	    	return 2*pere+1;
	    }
	    
	    public BinaryHeap(int taille)
	    {
	    	heapSize=taille;
	    	heap=new Double[taille][2];
	    	last=0;
	    }
	    
	    public void insert(Double idnoeud,Double poids)
	    {
	    	heap[last][0]=(double)idnoeud;
	    	heap[last][1]=(double) poids;
	    	last++;
	    	upHeap();
	    	
	    }
	    
	    public int size()
	    {
	    	return last;
	    }
	    
	    public void upHeap()
	    {
	    	int index=size();
	    	while(index>1)
	    	{
	    		int parent=index/2;
	    		
	    		if(heap[index-1][1]>heap[parent-1][1])
	    			break;
	    		swap(index-1,parent-1);
	    		index=parent;
	    	}
	    }
	    
	    public void swap(int i, int j)
	    {
	    	Double[] tempo=heap[i];
	    	heap[i]=heap[j];
	    	heap[j]=tempo;
	    }
	    
	    public Double[] min()
	    {
	    	if(isEmpty())
	    		return null;
	    	else
	    		return heap[0];
	    	
	    }
	    
	    public Double[] removeMin()
	    {
	    	Double[] min= min();
	    	heap[0]=heap[last];
	    	last--;
	    	downHeap();
	    	return min;
	    }
	    
	    public void downHeap()
	    {
	    	int index=1;
	    	while(true)
	    	{
	    		int child=index*2;
	    		if(child>size())
	    			break;
	    		if(child +1<= size())
	    			child=findMin(child, child+1);
	    		System.out.println(heap[index][1]);
	    		if(heap[index][1]-heap[child][1]>=0)
	    			break;
	    		swap(index,child);
	    		index=child;
	    	}
	    }
	    
	    public int findMin(int gauche, int droit)
	    {
	    	if(heap[gauche][1]-heap[droit][1]<=0)
	    		return gauche;
	    	else
	    		return droit;
	    }

	public static void main(String[] args)
	{
		BinaryHeap a=new BinaryHeap(7);
		a.insert(2.0, 10.0);
		a.insert(3.0, 3.0);
		a.insert(5.0, 6.0);
		a.insert(4.0, 2.0);
		System.out.println(a.heap[0][1]);
		Double[] cest=a.removeMin();
		System.out.println(a.heap[0][1]);
		
	}

}
