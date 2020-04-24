#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *left;
	struct node *right;
};

struct node *create()
{
	int x;
	struct node *nn=malloc(sizeof(struct node));
	printf("enter node\t");
	scanf("%d",&x);
	if(x==-1)
	{
		return NULL;
	}
	nn->data=x;
	printf("enter the left node of %d\t",x);
	nn->left=create();
	printf("enter the right node of %d\t",x);
	nn->right=create();
	
	return nn;
}

void preorder(struct node*t)
{
	if(t!=NULL){
	printf("%d->",t->data);
	preorder(t->left);
	preorder(t->right);
}
}

int main()
{
	struct node *root;
	root=create();
	printf("preorder traversal \n");
	preorder(root);
	return 0;
}
