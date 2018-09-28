#include<bits/stdc++.h>
using namespace std;
string encrypt(string plain,int key){
	string result;
	for(int i=0;i<plain.length();i++){
		result+=((plain[i]-97+key)%26)+97;
	}
	return result;
}
string decrypt(string cipher,int key){
	string result;
	for(int i=0;i<cipher.length();i++){
		int temp=((cipher[i]-97-key));
		result+=temp<0?26-abs(temp)+97:temp+97;
	}
	return result;
}
int main(){
	cout<<"Enter the plain text";
	string plain;
	cin>>plain;
	cout<<"Enter the key";
	int key;
	cin>>key;
	string cipher=encrypt(plain,key);
	cout<<"Encrypted text:"<<cipher<<endl;
	cout<<"Decrypted text:"<<decrypt(cipher,key);
	
}
