#include<stdio.h>
#include<stdlib.h>
struct node{
   int data;
   struct node *l,*r;
};
struct node *root=NULL;

struct node *create(int k)
  {
      struct node *n=malloc(sizeof(struct node));
       n->data=k;
       n->l=NULL;
       n->r=NULL;
       return n;
  }
struct node *insert(struct node *root,int k){
     if(root==NULL)
           return create(k);
      else if(k<root->data)
             root->l=insert(root->l,k);
        else
              root->r=insert(root->r,k);
       return root;   
  
}
void preorder(struct node*t)
{
	if(t!=NULL){
	printf("%d->",t->data);
	preorder(t->l);
	preorder(t->r);
	}
}

void inorder(struct node*t){
     if(t!=NULL)
        {
        inorder(t->l);
        printf("%d->",t->data);
        inorder(t->r);
}
}
int fdmix(struct node *root){
  struct node *t=root;
    while(t->l!=NULL)
       {
           t=t->l;
       }
       return t->data;
}
int fdmax(struct node *root){
  struct node *t=root;
    while(t->r!=NULL)
       {
           t=t->r;
       }
       return t->data;
}
int search(struct node *root,int k){
   if(root==NULL)
      return 0;
     else{
     if(root->data==k)
        return 1;
        else if(k<root->data)
            search(root->l,k);
           else if(k>root->data)
            search(root->l,k);
            
     }
}

void main(){
     int data;
     while(1){
         scanf("%d",&data);
          if(data==-1)
            break;
            if(root==NULL)
                root=insert(root,data);
             else
                insert(root,data);
     }
     printf("pre-order : ");
     preorder(root);
     printf("NULL");
     printf("\n");
     printf(" In-order : ");
     inorder(root);
     printf("NULL");
     
      int mix=fdmix(root);
      printf("\nMIN-ELEMENT : %d",mix);
      int max=fdmax(root);
      printf("\nMIN-ELEMENT : %d",max);
      printf("\n Enter node to search");
      int k;
      scanf("%d",&k);
       if(search(root,k))
          printf("\n SEARCH SUCCESSFULL ELEMENT FOUND");
          else
          printf("\n SEARCH SUCCESSFULL ELEMENT NOT FOUND");
}
