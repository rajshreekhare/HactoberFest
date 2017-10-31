import java.util.Scanner;

class Stack {
  int Capacity;
  int top; 
  char s[];
  
  Stack(int n)
  {
	  Capacity=n;
	  top=-1;
	  s=new char[Capacity];  
  }
  
  public boolean isEmpty()
  {
	  if(top==-1)
		  return true;
	  else 
		  return false;
  }
  
  public char peek()
  {
    	  return s[top];
  }
  
  void push(char x)
  {
	  if(top==Capacity-1)
		  return;
	  else 
		  top++;
      s[top]=x;		  
  }
  
  char pop()
  { char popped;
	  
	    popped=s[top];
	      top--;
		  return popped;
	  
  }
  
  int opPrec(char op)
  {
      switch (op)
      {
      case '+':
      case '-':
          return 1;
    
      case '*':
      case '/':
          return 2;
      }
      return -1;
  }
  
  void display()
  {
	  for(int i=0;i<=top;i++)
		  System.out.println(s[i]);
  }
  
}

public class InfixToPostfix {
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        char[] infix = new char[N];
        char[] postfix= new char[N];
        Stack st=new Stack(N);
        int i=0,len=0;
        for(int k=0;k<N;k++)
        {
        	infix[k]=sc.next().charAt(0);
        	postfix[k]=' ';
        }
        /*for(int j=0;j<N;j++)
        {
        	
        	System.out.print(postfix[j]+"-");
        }*/
        for(int j=0;j<N;j++)
        {  
        	char s=infix[j];
        	if(Character.isDigit(s)==true)
        		{
        			postfix[i]=s;
        			i++;
        		}
        		
        	else
        	{
        		if(s=='(')
        			st.push(s);	
        		else if(s==')')
        		{
        			while(!st.isEmpty()&&st.peek()!='(')
        				{
        				postfix[i]=st.pop();
        				i++;
        				}
        			
                        st.pop();// for removing "("
                        	
        		}
        		else
        		{
        			while (!st.isEmpty() && st.opPrec(s) < st.opPrec(st.peek()))
                        {
        				postfix[i] = st.pop();
                        i++;
                        }
                    st.push(s);
        		
        		}
        	}
        }
        while(!st.isEmpty())
        {
        	if(i<N)
        		{postfix[i]=st.pop();i++;}
        	else
        		System.out.println("error");
        }
        
        for(int j=0;j<N;j++)
        {
        	
        	System.out.print(postfix[j]+" ");
        }
    }
        
}
