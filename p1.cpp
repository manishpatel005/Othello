#include<string>
#include<iostream>
#include<stdio.h>
using namespace std;
string moves[] =   {"F5","E6","E3","G5","G6","F2","D6","C4","B5","B4","D3","A5","F7","E1","F8","B3","A7","C8","H3","H7","F1","D8","H2","G2","B2","C1","B8","G1","PS","G7","A1",""};
int main()
{
	string str;
	for(int i=0;moves[i].size()!=0;i++)
	{
		cin>>str;
		cout<<moves[i]<<endl;
		fflush(stdout);
	}
	return 0;
}
	
