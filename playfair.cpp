#include<bits/stdc++.h>
using namespace std;
int get_indexi(char a,char key_matrix[5][5]){
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			if(key_matrix[i][j]==a){
				return i; 
			}
		}
	}
}
int get_indexj(char a,char key_matrix[5][5]){
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			if(key_matrix[i][j]==a){
				return j; 
			}
		}
	}
}
int main(){
	cout<<"Enter the key";
	string key;
	cin>>key;
	set<char> unique_key_set;
	for(int i=0;i<key.length();i++){
		unique_key_set.insert(key[i]);
	};
	char key_matrix[5][5];
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			key_matrix[i][j]='-';
		}
	}
	int length=unique_key_set.size();
	set<char>::iterator irr;
	char unique_key[length];
	int k=0;
	for(int i=0;i<key.length();i++){
		if(unique_key_set.find(key[i])!=unique_key_set.end()){
			unique_key[k]=*unique_key_set.find(key[i]);
			unique_key_set.erase(unique_key_set.find(key[i]));
			k++;
		}
	}
	k=0;
	int size=length;
	for(int i=0;i<(size/5)+size%5;i++){
		for(int j=0;j<5;j++){
			if(length>0){
				key_matrix[i][j]=unique_key[k];
				length--;
				k++;
			}
			else{
				break;
			}
		}
	}
	char temp='a';
	length=sizeof(unique_key)/sizeof(char);
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			if(key_matrix[i][j]=='-'){
				int flag=1;
				for(int k=0;k<length;k++){
					if(temp==unique_key[k]){
						flag=0;
						break;
					}
				}
				if(flag==1){
					key_matrix[i][j]=temp;
					temp+=1;
					if(temp=='q')
						temp+=1;
				}
				else{
					i--;
					j--;
					temp+=1;
					if(temp=='q')
						temp+=1;
				}
			}
		}
	}
	cout<<"Key Matrix"<<endl;
	for(int i=0;i<5;i++){
		for(int j=0;j<5;j++){
			cout<<key_matrix[i][j];
		}
		cout<<endl;
	}
	string cipher="";
	cout<<"Enter the plain text";
	string plain;
	cin>>plain;
	if(plain.length()%2!=0){
		plain+='z';
	}
	string t=plain;
	plain="";
	for(int i=0;i<t.length();i+=2){
		if(t[i]==t[i+1]){
			plain+=t[i];
			plain+=t[i]+1;
			plain+=t[i];
		}
		else{
			plain+=t[i];
			plain+=t[i+1];
		}
	}
	for(int i=0;i<plain.length();i+=2){
		int first_i=get_indexi(plain[i],key_matrix);
		int first_j=get_indexj(plain[i],key_matrix);
		
		int second_i=get_indexi(plain[i+1],key_matrix);
		int second_j=get_indexj(plain[i+1],key_matrix);
		
		if(first_j==second_j){
			//same column
			cipher+=key_matrix[(first_i+1)%5][first_j];
			cipher+=key_matrix[(second_i+1)%5][first_j];
		}
		else if(first_i==second_i){
			//same row
			cipher+=key_matrix[first_i][(first_j+1)%5];
			cipher+=key_matrix[first_i][(second_j+1)%5];
		}
		else{
			cipher+=key_matrix[first_i][second_j];
			cipher+=key_matrix[second_i][first_j];
		}
		
	}
	cout<<"Encrypted Text"<<cipher;
	
}
