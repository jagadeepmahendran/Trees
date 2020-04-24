import java.io.*;
import java.util.*;
class inpretobt{
  class node{
    char data;
    node left,right;
    node(char data)
     {
       this.data=data;
       right=null;
       left=null;
     }
  }
  node root;
    static int pr = 0;
node binarytree(char in[],char pre[],int srt,int end){

  if(srt>end)
    return null;

    node tpnode=new node(pre[pr++]);
    if(srt==end)
        return tpnode;
        int indx=search(in,srt,end,tpnode.data);
     tpnode.left=binarytree(in,pre,srt,indx-1);

     tpnode.right=binarytree(in,pre,indx+1,end);
      return tpnode;

}
 int search(char ar[],int srt,int end,char key){
   int i;
   for(i=srt;i<=end;i++)
     {
       if(ar[i]==key)
           return i;
     }
     return i;
 }
   void printInorder(node nd){
     if(nd!=null)
       { printInorder(nd.left);
         System.out.print(nd.data+" ");
         printInorder(nd.right);
       }
   }
   node mirror(node n)
    {
      if(n==null)
       return n;

      n.left= mirror(n.left);
      n.right=mirror(n.right);

       node temp;

        temp=n.left;
        n.left=n.right;
        n.right=temp;

        return n;
    }
  public static void main(String args[])
   {
       inpretobt bt=new inpretobt();
       char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
       char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
       int len = in.length;
        node root=bt.binarytree(in,pre,0,len-1);

       // building the tree by printing inorder traversal
       System.out.println("Inorder traversal of constructed tree is : ");
       bt.printInorder(root);
       bt.mirror(root);
        System.out.println("Inorder traversal of mirror tree is : ");
       bt.printInorder(root);
   }


}
