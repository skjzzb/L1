#include<iostream>
using namespace std;

const int MIN=-1000;
const int MAX=1000;



int prune(int depth,int index,bool check,int alpha,int beta,int a[])
{


	if(depth==3)
	{
		return a[index];

	}


	if(check)
	{


		int best=MIN;

		for(int i=0;i<2;i++)

		{

			int value=prune(depth+1,2*index+i,false,alpha,beta,a);
			best=max(best,value);
			alpha=max(best,alpha);
	
			if(alpha>=beta)
			{
			
				break;


			}	

		}

		return best;
	}


	else
	{

		int best=MAX;

		for(int i=0;i<2;i++)
		{
		
			int value=prune(depth+1,2*index+i,true,alpha,beta,a);
			best=min(value,best);
			beta=min(best,value);
			if(beta<=alpha)
			{
		
				break;
			}

		}
		return best;


	}

}
int main()
{


	int a[8]={3, 5, 6, 9, 1, 2, 0, -1};

int value=prune(0,0,true,MIN,MAX,a);

cout<<"The pruned value "<<value<<endl;


}
