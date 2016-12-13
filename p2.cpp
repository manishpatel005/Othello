#include<string>
#include<iostream>
#include<stdio.h>
using namespace std;
string moves[] =  
{ "F6","F4","C5","G3","F3","E2","G4","C6","C3","A6","B6","E7","C7","D7","D2","A3","H5","H6","H4","D1","E8","C2","A4","A8","A2","B7","H1","H8","G8","B1" };
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
