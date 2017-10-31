import java.util.Scanner;
//This is an implementation of circular queue using arrays
//Queue is a FIFO data structure
class queue
{
	int size;
	int front;
	int rear;
	int q[];
	
	//to intialize queue
	queue(int N)
	{
		size=N;
		front=rear=-1;
		q=new int[size];
	}
	
	// to add element to queue
	void enqueue(int x)
	{
		if((front==rear)&&(rear==-1))
			front=rear=0;
		else if((rear+1)%size==front%size)
			return;
		else
		{
			rear=(rear+1)%size;
		}
		q[rear]=x;
			
	}
	
	//to remove element from queue
	int dequeue() 
	{
		if(front==-1)
			return -1;
		else
			{
			int data=q[front];
			
		    front=(front+1)%size;
		    
		    return data;}
	}
	
	void display()
	{
		//System.out.println(rear+ " "+ front);
		if(front==-1)
			return;
		else
		{
			int i=front;
			while(i!=rear)
			{
			
				System.out.print(q[i]+" ");
					i=(i+1)%size;
			}
			System.out.print(q[rear]);
		}
	}
}

public class ArrayQueue 
{	
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        queue myq= new queue(N);
        for(int i=0;i<N;i++)
        {
        	myq.enqueue(sc.nextInt());
        	
        }
       // myq.display();
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        //myq.display(); 
       //myq.dequeue();
       //myq.display();
        while(n2-->0)
       {
        int max=-1;
        int[] tempArray= new int[n1];
        for(int i=0;i<n1;i++)
        {	
        	tempArray[i]=myq.dequeue();
        }
        max=tempArray[0];
        for(int i=0;i<n1;i++ )
        	{
            	if(tempArray[i]>max)
            	{
            		max=tempArray[i];
            	}
        	}
       // System.out.println("max"+max);
        
        //myq.display();
        int dqcount=0;
        for(int i=0;i<n1;i++)
        {   
        	if(tempArray[i]!=max)
        		myq.enqueue(tempArray[i]);
        	else if(dqcount==0)
        		{//myq.dequeue();
        		 dqcount++;
        		 continue;
        		}
        	else
        		myq.enqueue(tempArray[i]);
        }
        
        }
        myq.display();
        
    }
        

}
