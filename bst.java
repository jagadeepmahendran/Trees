import java.util.*;
import java.io.*;
class bst{
  class node{
    int data;
    node right,left;
    node(int data)
      {
        this.data=data;
        left=right=null;
      }
  }
  node root;
 bst(){
   root=null;
 }


 void insert(int data)
   {
     root=insertv(root,data);
   }
node insertv(node root,int data){
  if(root==null)
      return new node(data);
    if(data<root.data)
       root.left=insertv(root.left,data);
     else if(data>root.data)
         root.right=insertv(root.right,data);
     return root;
}


 void preordr(){
   preorder(root);
 }
  void preorder(node t){
  //  node t=root;
    if(t!=null)
     {
       System.out.print(t.data+" ");
       preorder(t.left);
       preorder(t.right);
     }
  }

  int min(node t)
   {  int min=t.data;
     while(t.left!=null)
      {
        t=t.left;
        min=t.data;
      }
      return min;
   }


  void delete(){
    System.out.println("\nEnter node to delete");
    int k=sc.nextInt();
      root= delet(root,k);
      System.out.print("PRE_ORDER : ");
  }
  node delet(node root,int k){
    if(root==null)
       return root;
      if(k<root.data)
        root.left=delet(root.left,k);
        else if(k>root.data)
          root.right=delet(root.right,k);
        else{
          if (root.left == null)
               return root.right;
           else if (root.right == null)
               return root.left;
            root.data=min(root.right);
            root.right=delet(root.right,root.data);

        }
          return root;
  }
  public static Scanner sc=new Scanner(System.in);
public static void main(String[] e){
bst bt=new bst();

   while(true){
     int x=sc.nextInt();
     if(x==-1)
        break;
        bt.insert(x);
   }
  System.out.print("PRE_ORDER : ");
  bt.preordr();

   bt.delete();
   bt.preordr();
}

}
