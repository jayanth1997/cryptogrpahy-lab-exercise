#include<bits/stdc++.h>
using namespace std;
long int power(int a,int b,int mod)
{
long long int t;
t=(pow(a,b));
return t%mod;
}
long long int calculateKey(int a,int x,int n)
{
return power(a,x,n);
} 
int main()
{
int n,g,x,a,y,b;
// both the persons will be agreed upon the common n and g
cout<<"Enter the value of n and g : ";
cin>>n>>g;
// first person will choose the x
cout<<"Enter the value of x for the first person : ";
cin>>x; a=power(g,x,n);
// second person will choose the y
cout<<"Enter the value of y for the second person : ";
cin>>y; b=power(g,y,n);
cout<<"key for the first person is : "<<power(b,x,n);
cout<<"key for the second person is : "<<power(a,y,n);
return 0;
} 

