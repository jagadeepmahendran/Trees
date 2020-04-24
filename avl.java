 import java.util.*;
import java.io.*;
class avl{
    class node{
       int data,height;
        node left,right;
        node(int data){
           this.data=data;
            left=null;
            right=null;
            height=1;
        }
    }

    node root;
    avl(){
      root=null;
    }

    void preordr(){
      preorder(root);
    }
     void preorder(node t){
     //   node t=root;
       if(t!=null)
        {
          System.out.print(t.data+" ");
          preorder(t.left);
          preorder(t.right);
        }
     }


    int height(node n){
      if(n==null)
        return 0;
        return n.height;
    }
    int max(int a,int b){
      if(a>b)
       return a;
       else
        return b;
      }
      int getbal(node n){
        if(n==null)
          return 0;
          return height(n.left)-height(n.right);
      }

      node rightrot(node n){
         node x = n;
         node y=x.left;
         node t=y.right;
          y.right=x;
          x.left=t;
          x.height=max(height(x.left), height(x.right)) + 1;
          y.height = max(height(y.left), height(y.right)) + 1;
          return y;
      }
      node leftrot(node n)
       {
         node x=n;
         node y=x.right;
         node t=y.left;
          y.left=x;
          x.right=t;
          x.height=max(height(x.left), height(x.right)) + 1;
          y.height = max(height(y.left), height(y.right)) + 1;
          return y;
       }
   int min(node n)
    {
      int min=n.data;
      if(n.left!=null){
        n=n.left;
        min=n.data;
      }
      return min;
    }
/*
    void delete(int k){
      root=delet(root,k);
    }
    node delet(node root,int data)
     {
       if(root==null)
       return null;
       else if(data<root.data)
          root.left=delet(root.left,data);
          else if(data>root.data)
           root.right=delet(root.right,data);
           else{
             if(root.left==null)
                return root.left;
                if(root.right==null)
                 return root.right;

                 root.data=min(root);
                 root.right=delet(root.right,root.data);
           }

                        root.height=1+max(height(root.left),height(root.right));

                      int bal=getbal(root);

                    // right rotate
                      if( bal>1 && data <root.left.data)
                          return rightrot(root);

                          //left rotate
                       if(bal<-1 && data > root.right.data)
                          return leftrot(root);

                          // left rigth
                          if(bal >1 && data > root.left.data)
                             {
                               root.left=leftrot(root.left);
                                return rightrot(root);
                             }

                             //rigth left
                             if(bal<-1 && data < root.right.data)
                              {
                                root.right=rightrot(root.right);
                                return leftrot(root);
                              }



           return root;
     }

     */
    void insert(int data)
     {
       root=insertv(root,data);
     }
     node insertv(node root,int data){
          if(root==null)
             return new node(data);
             else if(data<root.data)
                root.left=insertv(root.left,data);
            else if(data>root.data)
                  root.right=insertv(root.right,data);
              else
              return root;

             root.height=1+max(height(root.left),height(root.right));

           int bal=getbal(root);

         // right rotate
           if( bal>1 && data <root.left.data)
               return rightrot(root);

               //left rotate
            if(bal<-1 && data > root.right.data)
               return leftrot(root);

               // left rigth
               if(bal >1 && data > root.left.data)
                  {
                    root.left=leftrot(root.left);
                     return rightrot(root);
                  }

                  //rigth left
                  if(bal<-1 && data < root.right.data)
                   {
                     root.right=rightrot(root.right);
                     return leftrot(root);
                   }
                   return root;
        }



public static Scanner sc=new Scanner(System.in);
    public static void main(String[] e){
      avl at=new avl();
      while(true){
        int x=sc.nextInt();
        if(x==-1)
           break;
           at.insert(x);
      }
     System.out.print("PRE_ORDER : ");
     at.preordr();
  /*   System.out.println("\nEnter the node to be deleted");
     int k=sc.nextInt();
     at.delete(k);
     System.out.print("PRE_ORDER : ");
     at.preordr();
   }*/
}
