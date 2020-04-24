import java.util.*;
class bst{
  class node{
    int data;
    node left,right;
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
 void insert(int data){
   root=insertv(root,data);
 }
  node insertv(node root,int data)
    {
       if(root==null)
            return new node(data);
            else if(data<root.data)
              root.left=insertv(root.left,data);
               else if(data>root.data)
                 root.right=insertv(root.right,data);
                return root;
   }
   void preordr()
     {
      // System.out.println("pre order===");
          preorder(root);
     }
     void preorder(node t)
      {
        if(t!=null)
         {

           preorder(t.left);
            System.out.print(t.data+" ");
           preorder(t.right);
         }
      }
      void printarray(int a[],int n)
        {
          for(int i=0;i<n;i++)
                System.out.print(a[i]+" ");
                System.out.println();
        }
    void printpaths()
        {
           int path[]=new int[1000];
            pathrec(root,path,0);
        }
        void pathrec(node t,int path[],int len)
         {

           if(t==null)
            return ;
           path[len++]=t.data;
             if(t.left==null&&t.right==null)
                    printarray(path,len);
                    else
                     {
                       pathrec(t.left,path,len);
                       pathrec(t.right,path,len);
                     }
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
  System.out.print("IN_ORDER : ");
  System.out.println();
  bt.preordr();
     bt.printpaths();

}
}
